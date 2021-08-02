package com.yuzee.common.lib.util;

import java.util.Arrays;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.util.ObjectUtils;

import com.yuzee.common.lib.enumeration.ContactTypeEnum;
import com.yuzee.common.lib.enumeration.CourseTypeEnum;
import com.yuzee.common.lib.enumeration.EntitySubTypeEnum;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;
import com.yuzee.common.lib.enumeration.ExampleVideoCategoryTypeEnum;
import com.yuzee.common.lib.enumeration.ExperienceEntityTypeEnum;
import com.yuzee.common.lib.enumeration.FavoriteEntityTypeEnum;
import com.yuzee.common.lib.enumeration.LanguageProficiencyTypeEnum;
import com.yuzee.common.lib.enumeration.NetworkCategoryEnum;
import com.yuzee.common.lib.enumeration.PrivacyLevelEnum;
import com.yuzee.common.lib.enumeration.StudentCategoryEnum;
import com.yuzee.common.lib.enumeration.TaskNameEnum;
import com.yuzee.common.lib.enumeration.TransactionTypeEnum;
import com.yuzee.common.lib.enumeration.VerifiedEnum;
import com.yuzee.common.lib.exception.ValidationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtil {

	private static final String PRIVACY_LEVEL_TYPE_VALIDATION_MESSAGE="privacy_level must be in one of the following: ";
	private static final String ENTITY_SUB_TYPE_VALIDATION_MESSAGE = "entity_sub_type must be in one of the following: ";
	private static final String LANGUAGE_PROFICIENCY_TYPE_VALIDATION_MESSAGE="language_proficiency must be in one of the following: ";
	private static final String EXAMPLE_VIDEO_CATEGORY_TYPE_VALIDATION_MESSAGE="example_video_category_type must be in one of the following: ";
	private static final String VERIFICATION_ENUM_VALIDATION_MESSAGE = "verification value must be in one of the following: ";

	private static final String TASK_NAME_VALIDATION_MESSAGE = "task_name must be in one of the following: ";

	private ValidationUtil() {

	}
	
	public static void validateLanguageProficiencyEnum(String languageProficiencyType) throws ValidationException {
		LanguageProficiencyTypeEnum languageProficiencyTypeEnum = EnumUtils.getEnum(LanguageProficiencyTypeEnum.class, languageProficiencyType);
		if (ObjectUtils.isEmpty(languageProficiencyTypeEnum)) {
			log.error(LANGUAGE_PROFICIENCY_TYPE_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(LanguageProficiencyTypeEnum.class)));
			throw new ValidationException(LANGUAGE_PROFICIENCY_TYPE_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(LanguageProficiencyTypeEnum.class)));
		}
	}
	
	public static void validateExampleVideoCategoryEnum(String exampleVideoCategoryType) throws ValidationException {
		ExampleVideoCategoryTypeEnum exampleVideoCategoryTypeEnum = EnumUtils.getEnum(ExampleVideoCategoryTypeEnum.class, exampleVideoCategoryType);
		if (ObjectUtils.isEmpty(exampleVideoCategoryTypeEnum)) {
			log.error(EXAMPLE_VIDEO_CATEGORY_TYPE_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(ExampleVideoCategoryTypeEnum.class)));
			throw new ValidationException(EXAMPLE_VIDEO_CATEGORY_TYPE_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(ExampleVideoCategoryTypeEnum.class)));
		}
	}
	
	public static void validateVarifiedEnum(String verifiedFlag) {
		VerifiedEnum verifiedEnum = EnumUtils.getEnum(VerifiedEnum.class, verifiedFlag);
		if (ObjectUtils.isEmpty(verifiedEnum)) {
			log.error(VERIFICATION_ENUM_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(VerifiedEnum.class)));
			throw new ValidationException(VERIFICATION_ENUM_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(VerifiedEnum.class)));
		}
	}
	
	public static void validateEntitySubtypeEnum(String entitySubType) {
		EntitySubTypeEnum entitySubTypeEnum = EnumUtils.getEnum(EntitySubTypeEnum.class, entitySubType);
		if (ObjectUtils.isEmpty(entitySubTypeEnum)) {
			log.error(ENTITY_SUB_TYPE_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(EntitySubTypeEnum.class)));
			throw new ValidationException(ENTITY_SUB_TYPE_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(EntitySubTypeEnum.class)));
		}
	}
	
	public static void validatePrivacyLevelEnum(String privacyLevel) throws ValidationException {
		PrivacyLevelEnum privacyLevelEnum = EnumUtils.getEnum(PrivacyLevelEnum.class, privacyLevel);
		if (ObjectUtils.isEmpty(privacyLevelEnum)) {
			log.error(PRIVACY_LEVEL_TYPE_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(PrivacyLevelEnum.class)));
			throw new ValidationException(PRIVACY_LEVEL_TYPE_VALIDATION_MESSAGE
					+ Arrays.toString(Utils.getEnumNames(PrivacyLevelEnum.class)));
		}
	}

	public static void validateCourseType(String courseType) throws ValidationException {
		if (!EnumUtils.isValidEnumIgnoreCase(CourseTypeEnum.class, courseType)) {
			log.error("course_type must be in one of the following {}",
					Utils.getEnumNamesAsString(CourseTypeEnum.class));
			throw new ValidationException(
					"course_type must be in one of the following: " + Utils.getEnumNamesAsString(CourseTypeEnum.class));

		}
	}

	public static void validatEntityType(String entityType) throws ValidationException {
		if (!EnumUtils.isValidEnum(EntityTypeEnum.class, entityType)) {
			log.error("entity_type must be in one of the following {}",
					Utils.getEnumNamesAsString(EntityTypeEnum.class));
			throw new ValidationException(
					"entity_type must be in one of the following: " + Utils.getEnumNamesAsString(EntityTypeEnum.class));

		}
	}

	public static void validateStudentCategory(String studentCategory) throws ValidationException {

		if (!EnumUtils.isValidEnumIgnoreCase(StudentCategoryEnum.class, studentCategory)) {
			String studentCategories = Arrays.toString(Utils.getEnumNames(StudentCategoryEnum.class));
			log.info("student_category must be in one of the following: ", studentCategories);
			throw new ValidationException("student_category must be in one of the following: " + studentCategories);
		}
	}

	public static void validateNetworkCategory(String studentType) throws ValidationException {
		if (!EnumUtils.isValidEnumIgnoreCase(NetworkCategoryEnum.class, studentType)) {
			String studentTypes = Arrays.toString(Utils.getEnumNames(NetworkCategoryEnum.class));
			log.info("student_type must be in one of the following: ", studentTypes);
			throw new ValidationException("student_type must be in one of the following: " + studentTypes);
		}
	}
	
	public static void validateEntityType(String entityType) {
		if (!EnumUtils.isValidEnum(EntityTypeEnum.class, entityType)) {
			log.error("entityType must be in one of the following {}",
					Arrays.toString(Utils.getEnumNames(EntityTypeEnum.class)));
			throw new ValidationException("entityType must be in one of the following: "
					+ Arrays.toString(Utils.getEnumNames(EntityTypeEnum.class)));
		}
	}
	
	public static void validateFavoriteEntityType(String entityType) {
		if (!EnumUtils.isValidEnum(FavoriteEntityTypeEnum.class, entityType)) {
			log.error("entityType must be in one of the following {}",
					Arrays.toString(Utils.getEnumNames(FavoriteEntityTypeEnum.class)));
			throw new ValidationException("entityType must be in one of the following: "
					+ Arrays.toString(Utils.getEnumNames(FavoriteEntityTypeEnum.class)));
		}
	}

	public static void validateTransactionType(String transactionType) {
		if (!EnumUtils.isValidEnum(TransactionTypeEnum.class, transactionType)) {
			log.error("trancationType must be in one of the following {}",
					Arrays.toString(Utils.getEnumNames(TransactionTypeEnum.class)));
			throw new ValidationException("trancationType must be in one of the following: "
					+ Arrays.toString(Utils.getEnumNames(TransactionTypeEnum.class)));
		}
	}

	public static void validateContactType(String contactType) {
		if (!EnumUtils.isValidEnum(ContactTypeEnum.class, contactType)) {
			log.error("contact_type must be in one of the following {}",
					Arrays.toString(Utils.getEnumNames(ContactTypeEnum.class)));
			throw new ValidationException("contact_type must be in one of the following: "
					+ Arrays.toString(Utils.getEnumNames(ContactTypeEnum.class)));
		}
	}

	public static void validateExperienceEntityType(String entityType) {
		if (!EnumUtils.isValidEnum(EntityTypeEnum.class, entityType)) {
			log.error("entityType must be in one of the following {}",
					Arrays.toString(Utils.getEnumNames(ExperienceEntityTypeEnum.class)));
			throw new ValidationException("entityType must be in one of the following: "
					+ Arrays.toString(Utils.getEnumNames(ExperienceEntityTypeEnum.class)));
		}
	}
	

	public static void validateTaskName(String taskName) {
		if (!EnumUtils.isValidEnum(TaskNameEnum.class, taskName)) {
			log.error(TASK_NAME_VALIDATION_MESSAGE +
				Arrays.toString(Utils.getEnumNames(TaskNameEnum.class)));
			throw new ValidationException(TASK_NAME_VALIDATION_MESSAGE +
				Arrays.toString(Utils.getEnumNames(TaskNameEnum.class)));
		}
	}
}
