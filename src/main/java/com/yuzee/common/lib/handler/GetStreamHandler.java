package com.yuzee.common.lib.handler;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuzee.common.lib.constants.IConstant;

import io.getstream.client.Client;
import io.getstream.core.LookupKind;
import io.getstream.core.exceptions.StreamException;
import io.getstream.core.models.EnrichedActivity;
import io.getstream.core.models.Reaction;
import io.getstream.core.options.EnrichmentFlags;
import io.getstream.core.options.Filter;
import io.getstream.core.options.Limit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.getstream-handler.enabled", havingValue = "true")
public class GetStreamHandler {
	
	@Autowired
	private Client client;
	@Autowired
	private ObjectMapper objectMapper;
		
	private static final String COMMENT = "comment";
	
	private static final String COMMENT_ID = "commentId";
	
	private static final String REACTION_TEXT = "reactionText";
	

	public List<EnrichedActivity> getFeedData(String userId, String feedName, String idLessThan, Integer limit) throws InterruptedException, ExecutionException, StreamException {
		log.info("Getting feed data for user id {} for feed name {}",userId,feedName);
		if (StringUtils.isEmpty(idLessThan)) {
			return client.flatFeed(feedName, userId)
			        .getEnrichedActivities(new Limit(limit),new EnrichmentFlags()
			                .withReactionCounts().withOwnReactions().withRecentReactions()).get();
		} else {
			return client.flatFeed(feedName, userId)
			        .getEnrichedActivities(new Limit(limit),new Filter().idLessThan(idLessThan),new EnrichmentFlags()
			                .withReactionCounts().withOwnReactions().withRecentReactions()).get();
		}
	}
	
	
	public Reaction addLike(String userId ,String activityId, String reactionText) throws InterruptedException, ExecutionException, StreamException {
		log.info("Adding like for activityId {} by userId {}",activityId,userId);
		Reaction like = new Reaction.Builder()
				.kind("like")
				.extraField(REACTION_TEXT, reactionText)
				.activityID(activityId)
				.build();
		return this.client.reactions().add(userId, like).join();
	}

	public Reaction addLikeToCommentAndReply(String userId, String reactionId, String reactionText)
			throws InterruptedException, ExecutionException, StreamException {
		log.info("Adding like for reactionId {} by userId {}", reactionId, userId);
		Reaction like = new Reaction.Builder().kind("like")
				.extraField(REACTION_TEXT, reactionText).build();
		return this.client.reactions().addChild(userId, reactionId, like).join();
	}



	public Reaction addComment(String userId ,String activityId, String commentText, String commentId, Set<String> gifs, Set<String> hashtag, Set<String> userMentioned) throws StreamException, JsonProcessingException {
		log.info("Adding comment for activityId {} by userId {}",activityId,userId);
		Reaction comment = new Reaction.Builder()
				.kind(COMMENT)
				.activityID(activityId)
				.extraField("text", commentText).extraField(COMMENT_ID, commentId)
				.extraField(IConstant.GIFS, objectMapper.writeValueAsString(gifs))
				.extraField(IConstant.HASHTAG, objectMapper.writeValueAsString(hashtag))
				.extraField(IConstant.USER_MENTIONED, objectMapper.writeValueAsString(userMentioned))
				.build();
		return this.client.reactions().add(userId, comment).join();
	}

	public Reaction addReply(String userId ,String reactionId, String commentText, String commentId, Set<String> gifs) throws StreamException, JsonProcessingException {
		log.info("Adding reply for reactionId {} by userId {}",reactionId,userId);
		Reaction comment = new Reaction.Builder()
				.kind(COMMENT)
				.extraField("text", commentText).extraField(COMMENT_ID, commentId)
				.extraField(IConstant.GIFS, objectMapper.writeValueAsString(gifs))
				.build();
		return	this.client.reactions().addChild(userId, reactionId, comment).join();
	}

	public List<Reaction> getComments(String activityId, String reactionId, Integer limit) throws StreamException {
		if (StringUtils.isEmpty(reactionId)) {
			log.info("Getting initial {} comments for activity Id",limit);
			return  client.reactions().filter(LookupKind.ACTIVITY, activityId ,new Limit(limit), COMMENT).join();
		} else {
			log.info("Getting {} comment after reaction id {}",limit,reactionId);
			return  client.reactions().filter(LookupKind.ACTIVITY, activityId, new Filter().idLessThan(reactionId), new Limit(limit),COMMENT).join();
		}
	}


	public List<Reaction> getCommentReplies(String reactionId,String reactionAfter, Integer limit) throws StreamException {
		if (StringUtils.isEmpty(reactionAfter)) {
			log.info("Getting initial {} comments for activity Id",limit);
			return  client.reactions().filter(LookupKind.REACTION, reactionId ,new Limit(limit), COMMENT).join();
		} else {
			log.info("Getting {} comment after reaction id {}",limit,reactionId);
			return  client.reactions().filter(LookupKind.REACTION, reactionId, new Filter().idLessThan(reactionAfter), new Limit(limit),COMMENT).join();
		}
	}

}
