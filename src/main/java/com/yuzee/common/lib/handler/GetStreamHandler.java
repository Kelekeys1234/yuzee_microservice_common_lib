package com.yuzee.common.lib.handler;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
	
//	private static final String TIMELINE_FEED = "timeline";
	
//	private static final String USER_FEED = "user";
	
//	private DateFormat dateFormat;
	
	@Autowired
	private Client client;
	
//	private static final String MSG_CREATE_FOLLOW = "Create a follow relation between followerId {} and followingId {}";
//	private static final String MSG_REMOVE_FOLLOW = "Remove a follow relation between followerId {} and followingId {}";
	
//	private static final String ENTITY_TYPE = "entityType";
	private static final String COMMENT = "comment";
	private static final String COMMENT_ID = "commentId";
	private static final String REACTION_TEXT = "reactionText";
	
//	@PostConstruct
//	public void init () {
//		log.info("Inside GetStreamHandler.init() method");
//		TimeZone timeZone = TimeZone.getTimeZone("UTC");
//		dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
//		dateFormat.setTimeZone(timeZone);
//	}
	
//	public void updateGetStreamUserProfilePicture(String userId, String profilePicturePath) throws StreamException {
//		log.info("updating user image in get stream with user id {}", userId);
//		Data data = client.user(userId).get().join();
//		if (!ObjectUtils.isEmpty(data)) {
//			data.set("image_url", profilePicturePath);
//			client.user(userId).update(data).join();
//		}
//	
//	}
	
//	public void createNetwork(String followerId, String followingId, UserConnectionType connectionType)
//			throws StreamException {
//
//		if (connectionType.equals(UserConnectionType.FOLLOW)) {
//			log.info(MSG_CREATE_FOLLOW, followerId, followingId);
//			this.addGetStreamFollow(followerId, followingId);
//		} else if (connectionType.equals(UserConnectionType.CONNECTION)) {
//			log.info(MSG_CREATE_FOLLOW, followerId, followingId);
//			this.addGetStreamFollow(followerId, followingId);
//			log.info(MSG_CREATE_FOLLOW, followingId, followerId);
//			this.addGetStreamFollow(followingId, followerId);
//		}
//	}

//	public void removeNetwork(String followerId, String followingId, UserConnectionType connectionType)
//			throws StreamException {
//
//		if (connectionType.equals(UserConnectionType.FOLLOW)) {
//			log.info(MSG_REMOVE_FOLLOW, followerId, followingId);
//			this.removeGetStreamFollow(followerId, followingId);
//		} else if (connectionType.equals(UserConnectionType.CONNECTION)) {
//			log.info(MSG_REMOVE_FOLLOW, followerId, followingId);
//			this.removeGetStreamFollow(followerId, followingId);
//			log.info(MSG_REMOVE_FOLLOW, followingId, followerId);
//			this.removeGetStreamFollow(followingId, followerId);
//		}
//
//	}

//	private void addGetStreamFollow(String followerId, String followingId) throws StreamException {
//		log.info("Creating Time line feed for followerId {}", followerId);
//		FlatFeed followerTimeLineFeed = client.flatFeed(TIMELINE_FEED, followerId);
//		log.info("Creating User feed for followingId {}", followingId);
//		FlatFeed followingUserFeed = client.flatFeed(USER_FEED, followingId);
//		followerTimeLineFeed.follow(followingUserFeed).join();
//	}

//	private void removeGetStreamFollow(String followerId, String followingId) throws StreamException {
//		log.info("Creating Time line feed for followerId {}", followerId);
//		FlatFeed followerTimeLineFeed = client.flatFeed(TIMELINE_FEED, followerId);
//		log.info("Creating User feed for followingId {}", followingId);
//		FlatFeed followingUserFeed = client.flatFeed(USER_FEED, followingId);
//		followerTimeLineFeed.unfollow(followingUserFeed).join();
//	}
//	public void deleteGetStreamUserProfilePicture(String userId) throws StreamException {
//		log.info("updating user image in get stream with user id {}", userId);
//		Data data = client.user(userId).get().join();
//		if (!ObjectUtils.isEmpty(data)) {
//			data.set("image_url", "");
//			client.user(userId).update(data).join();
//		}
//	}
	
//	public void addEventInGetStream(String eventId,String entityId , String entityType, String eventText) throws ParseException, StreamException {
//		log.info("Adding event with event id {} having entity id {} , entity type {} , post type {}",eventId,entityId,entityType, "EVENT");
//		Activity activity = Activity.builder().
//				actor(entityId).object(eventText).
//				verb("EVENT").foreignID(eventId).extraField(ENTITY_TYPE, entityType).time(dateFormat.parse(dateFormat.format(new Date()))).build();
//		FlatFeed userFeed = client.flatFeed("user", entityId);
//		userFeed.addActivities(activity).join();
//	}
	
//	public void removeEventFromGetStream(String eventId, String entityId) throws StreamException {
//		log.info("Deleting event from Get stream with event id {} and entity id {} ",eventId,entityId);
//		FlatFeed userFeed = client.flatFeed("user", entityId);
//		userFeed.removeActivityByForeignID(eventId).join();
//	}
	
//	public void addPostInGetStream(String postId,String entityId , String entityType, PostTypeEnum postType ,String postText ,Set<String> mentionedUserIds , Set<String> mentionedHashTag ) throws StreamException, ParseException {
//		log.info("Adding post with post id {} having entity id {} , entity type {} , post type {}",postId,entityId,entityType,postType.toString());
//		Activity activity = Activity.builder().
//				actor(entityId).
//				verb(postType.toString()).foreignID(postId).extraField(ENTITY_TYPE, entityType).time(dateFormat.parse(dateFormat.format(new Date()))).
//				object(!StringUtils.isEmpty(postText) ? postText : "empty description" ).time(new Date()).to(mentionedUserIds.stream().map(mentionedUserId -> new FeedID("notification:"+ mentionedUserId)).collect(Collectors.toList())).build();
//		FlatFeed userFeed = client.flatFeed("user", entityId);
//		userFeed.addActivities(activity).join();
//	}

//	public void removePostFromGetStream(String postId, String entityId) throws StreamException {
//		log.info("Deleting post from Get stream with post id {} and entity id {} ",postId,entityId);
//		FlatFeed userFeed = client.flatFeed("user", entityId);
//		userFeed.removeActivityByForeignID(postId).join();
//	}
	
//	public void updatePostInGetStream(String postId,String entityId , String entityType, PostTypeEnum postType ,String postText ,Set<String> mentionedUserIds , Set<String> mentionedHashTag ) throws StreamException, ParseException {
//		log.info("updating post with post id {} having entity id {} , entity type {} , post type {}",postId,entityId,entityType,postType.toString());
//		Activity activity = Activity.builder().
//				actor(entityId).
//				verb(postType.toString()).foreignID(postId).extraField(ENTITY_TYPE, entityType).time(dateFormat.parse(dateFormat.format(new Date()))).
//				object(postText).time(new Date()).to(mentionedUserIds.stream().map(mentionedUserId -> new FeedID("notification:"+ mentionedUserId)).collect(Collectors.toList())).build();
//		client.batch().updateActivities(activity);	
//	}
	
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
	
//	public void createGetStreamUser(String userId, String userName) throws StreamException {
//		log.info("Creating user in get stream with user id {}", userId);
//		client.user(userId).create(new Data().set("user_name", userName)).join();
//	}
	
	
//	public void updateGetStreamUser(String userId, String userName) throws StreamException {
//		log.info("Creating user in get stream with user id {}", userId);
//		client.user(userId).update(new Data().set("user_name", userName)).join();
//	}
	
//	public void deleteGetStreamUser(String userId) throws StreamException {
//		log.info("Get all activities associated with user id {} and deleting it",userId);
//		FlatFeed userFlatFeed = client.flatFeed("user", userId);
//		List<Activity> listOfActivity = userFlatFeed.getActivities().join();
//		for (Activity activity : listOfActivity) {
//			log.info("Removing activity with foreign Id {} by user id {}",activity.getForeignID(), userId);
//			userFlatFeed.removeActivityByForeignID(activity.getForeignID());
//		}
//		log.info("Deleting user in get stream having user id {}",userId);
//		client.user(userId).delete().join();
//	}
	
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


//	public void deleteReaction(String reactionId) throws StreamException {
//		log.info("Removing reaction with reactionId {}", reactionId);
//		this.client.reactions().delete(reactionId).join();
//	}

	public Reaction addComment(String userId ,String activityId, String commentText, String commentId) throws StreamException {
		log.info("Adding comment for activityId {} by userId {}",activityId,userId);
		Reaction comment = new Reaction.Builder()
				.kind(COMMENT)
				.activityID(activityId).extraField("text", commentText).extraField(COMMENT_ID, commentId)
				.build();
		return this.client.reactions().add(userId, comment).join();
	}

	public Reaction addReply(String userId ,String reactionId, String commentText, String commentId) throws StreamException {
		log.info("Adding reply for reactionId {} by userId {}",reactionId,userId);
		Reaction comment = new Reaction.Builder()
				.kind(COMMENT)
				.extraField("text", commentText).extraField(COMMENT_ID, commentId)
				.build();
		return	this.client.reactions().addChild(userId, reactionId, comment).join();
	}

//	public void updateComment(String userId, String reactionId, String commentText, String commentId) throws StreamException {
//		log.info("Updating comment with reactionId {} by userId {}",reactionId,userId);
//		Reaction updatedComment = new Reaction.Builder()
//				.id(reactionId)
//				.extraField("text", commentText).extraField(COMMENT_ID, commentId)
//				.build();
//		this.client.reactions().update(updatedComment).join();
//	}

//	public void removeComment(String userId, String reactionId) throws StreamException {
//		log.info("Removing comment with reactionId {} by userId {}",reactionId,userId);
//		this.client.reactions().delete(reactionId).join();
//	}

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

//	public void addVote (String userId ,String activityId, VoteValueEnum voteValueEnum ) throws StreamException {
//		log.info("Adding vote type {} for activityId {} by userId {}",voteValueEnum.toString(),activityId,userId);
//		Reaction like = new Reaction.Builder()
//				.kind(voteValueEnum.name())
//				.activityID(activityId)
//				.build();
//		this.client.reactions().add(userId, like).join();	
//	}
}
