package com.yuzee.common.lib.constants;

public class IConstant {
	
	private IConstant() {}

	public static final String USER_SERVICE = "USER-SERVICE/users";

	public static final String USER_CONNECTION_URL = "http://" + USER_SERVICE;

	public static final String INTERACTION_SERVICE = "INTERACTION-SERVICE/interaction-service/api/v1";

	public static final String INTERACTION_CONNECTION_URL = "http://" + INTERACTION_SERVICE;

	public static final String ELIGIBILITY_CONNECTION_URL = "http://ELIGIBILITY-SERVICE/eligibility/api/v1";

	public static final String ELIGIBILITY_TEST_BASE_PATH = "http://ELIGIBILITY-SERVICE/eligibility";

	public static final String INSTITTUE = "INSTITUTE-SERVICE/institute/api/v1";

	public static final String INSTITUTE_CONNECTION_URL = "http://" + INSTITTUE;

	public static final String USER_VIEW_COURSE_CONNECTION_URL = INSTITUTE_CONNECTION_URL + "/view/visit/entity";

	public static final String COURSE_COUNT_INSTITUTE_URL = INSTITUTE_CONNECTION_URL + "/totalCourseCount";

	public static final String COURSE_DOMESTIC_RANKING = INSTITUTE_CONNECTION_URL + "/domesticRankingForCourse";

	public static final String CURRENCY_CONVERSION_RATE_URL = INSTITUTE_CONNECTION_URL + "/currency/rate";

	public static final String STORAGE = "STORAGE-SERVICE/storage";

	public static final String STORAGE_CONNECTION_URL = "http://" + STORAGE;

	public static final String CONNECTION = "CONNECTIONS/connection";

	public static final String CONNECTION_URL = "http://" + CONNECTION + "/api/v1";
	
	public static final String CONNECTION_BASE_PATH = "http://CONNECTIONS/connection";

	public static final String COMMON = "COMMON-API/common";

	public static final String COMMON_URL = "http://" + COMMON + "/api/v1";

	public static final String REVIEW = "REVIEW-SERVICE/review/api/v1";

	public static final String REVIEW_CONNECTION_URL = "http://" + REVIEW;
	
	public static final String EVENT = "EVENT-SERVICE/event-service/api/v1";

	public static final String EVENT_CONNECTION_URL = "http://" + REVIEW;
	
	public static final String VIEW_TRANSACTION = "VIEW-TRANSACTION/transaction";

	public static final String VIEW_TRANSACTION_URL = "http://" + VIEW_TRANSACTION + "/api/v1/transaction";
	
	public static final String VIEW_TRANSACTIONS_BASE_PATH = "http://VIEW-TRANSACTION/transaction";

	public static final String NUMBEO_URL = "https://www.numbeo.com/api";

	public static final String NOTIFICATION = "NOTIFICATION-SERVICE/notification/api/v1";

	public static final String NOTIFICATION_CONNECTION_URL = "http://" + NOTIFICATION;

	public static final String APPLICATION = "APPLICATION-SERVICE/application/api/v1";

	public static final String APPILICATION_URL = "http://" + APPLICATION;

	public static final String ELASTIC_SEARCH = "ELASTIC-SEARCH/elasticSearch";

	public static final String ELASTIC_SEARCH_INDEX = "yuzee_dev";

	public static final String ELASTIC_SEARCH_URL = "http://" + ELASTIC_SEARCH + "/";

	public static final String ELASTIC_SEARCH_BULK = ELASTIC_SEARCH_URL + "bulk";
	
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	public static final String AUTHORIZATION = "AUTHORIZATION-SERVICE/authorization-service";
	
	public static final String AUTHORIZATION_BASE_PATH = "http://"+AUTHORIZATION;
	
	public static final String REVIEW_BASE_PATH = "http://REVIEW-SERVICE/review";
	
	public static final String ELASTIC_SEARCH_INDEX_GENERIC = "yuzee_dev";
	
	public static final String ELASTIC_SEARCH_USER_TYPE = "user";
	
	public static final String EMAIL_URL = "http://" + NOTIFICATION + "/email";
	
	public static final String EVENT_QUEUE_NOTIFICATION = "EVENT_QUEUE_NOTIFICATION";	
	
	public static final String POST = "FEED-SERVICE/feed-service";
	
	public static final String POST_URL = "http://" + POST + "/api/v1";
	
	public static final String EVENT_QUEUE_STORAGE_EVENTS="EVENT_QUEUE_STORAGE_EVENTS";
	
	public static final String ACTIVE_MQ_DLQ="ActiveMQ.DLQ";

	public static final String FILE_PATH = "/home/ec2-user/RemainingRecordsFile/";
	
	public static final String FOLDER_NAME = "remainingRecords/";

	public static final String COMPANY = "COMPANY-SERVICE/company-service/api/v1";

	public static final String COMPANY_CONNECTION_URL = "http://" + COMPANY;
}
