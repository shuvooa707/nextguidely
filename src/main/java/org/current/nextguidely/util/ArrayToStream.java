package org.current.nextguidely.util;

import java.util.stream.Stream;

public class ArrayToStream<T> {
	public static <T> Stream<T> toStream(T[] array) {
		return Stream.of(array);
	}
}
