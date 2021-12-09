package com.yuzee.common.lib.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

	private Utils() {}
	
	private static Random random = new Random(new Date().getTime());
	
	public static String getOneTimePassword() {
		return "" + random.nextInt(9) + "" + random.nextInt(9) + "" + random.nextInt(9) + "" + random.nextInt(9);
	}

	public static Double limitTo2Decimals(final Double convertedRate) {
		BigDecimal bd = BigDecimal.valueOf(convertedRate).setScale(0, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static String[] getEnumNames(Class<? extends Enum<?>> e) {
		return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}
	
	public static String getEnumNamesAsString(Class<? extends Enum<?>> e) {
		return Arrays.toString(Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new));
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}
	
	public static boolean containsIgnoreCase(List<String> list, String searchKey) {
		return list.stream().anyMatch(e -> e.equalsIgnoreCase(searchKey));
	}

	public static boolean contains(List<String> list, String searchKey) {
		return list.stream().anyMatch(e -> e.equals(searchKey));
	}

	public static boolean contains(List<Date> list, Date searchDate) {
		return list.stream().anyMatch(e -> e.toInstant().compareTo(searchDate.toInstant()) == 0);
	}
	
	public static String getDistinctFileName(final String fileName) {
		final Calendar calendar = Calendar.getInstance();
		final long timeInMillis = calendar.getTimeInMillis();
		final String assetFile = StringUtils.cleanPath(fileName);
		String extension = "";
		StringBuilder fileNameWithOutExtension;

		final int lastIndex = assetFile.lastIndexOf('.');

		extension = assetFile.substring(lastIndex + 1);
		fileNameWithOutExtension = new StringBuilder(assetFile.substring(0, lastIndex));

		final StringBuilder newFileName = fileNameWithOutExtension.append("_").append(String.valueOf(timeInMillis)).append(".").append(extension);
		return newFileName.toString();
	}

	public static String generateRandomString(final int length, final boolean useLetters, final boolean useNumbers) {
		return RandomStringUtils.random(length, useLetters, useNumbers);
	}
	

	public static String generateReadableId(String name) {
	    return name + "-" + RandomStringUtils.randomAlphanumeric(7);
	}

	public static String convertToLowerCaseAndRemoveSpace(String name) {
		return StringUtils.isEmpty(name) ? "" : name.toLowerCase().replace(" ", "-");
	}
	
	public static double getSafeDouble(Double value) {
		return ObjectUtils.isEmpty(value)?0.0:value;
	}
	
	public static boolean isValidURL(String url) {
		return UrlValidator.getInstance().isValid(url) || UrlValidator.getInstance().isValid("http://"+url);  
	}
	
	private static final String NAMESPACE = "YUZEE";

    /**
     * 
     * Generates unique uuid against a name.
     * 
     * @param name
     *            is basically a unique field of entity.
     *            <br>
     *            For Example in User it can be phone number as it will be
     *            unique against every user.
     *            <br>
     *            NOTE: Incase name is changed the regenerate uuid.
     * @return UUID String. Null incase name is null or empty
     */
    public static String generateUUID(String name)
    {
        if (StringUtils.isEmpty(name))
        {
            return null;
        }
        String source = NAMESPACE + name;
        UUID uuid = UUID.nameUUIDFromBytes(source.getBytes());
        return uuid.toString();
    }
    
    public static String generateUUID()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
