package com.google.gson.metrics;

public class BenchMarkUtil {
    public static BagOfPrimitives readBagOfPrimitivesFromJsonReader(JsonReader jr) throws IOException {
        long longValue = 0;
        int intValue = 0;
        boolean booleanValue = false;
        String stringValue = null;
        jr.beginObject();
        while (jr.hasNext()) {
            String name = jr.nextName();
            switch (name) {
                case "longValue":
                    longValue = jr.nextLong();
                    break;
                case "intValue":
                    intValue = jr.nextInt();
                    break;
                case "booleanValue":
                    booleanValue = jr.nextBoolean();
                    break;
                case "stringValue":
                    stringValue = jr.nextString();
                    break;
                default:
                    throw new IOException("Unexpected name: " + name);
            }
        }
        jr.endObject();
        return new BagOfPrimitives(longValue, intValue, booleanValue, stringValue);
    }

    public static void assignFieldsByReflection(JsonReader jr, Object obj) throws Exception {
        jr.beginObject();
        while (jr.hasNext()) {
            String name = jr.nextName();
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            if (fieldType.equals(long.class)) {
                field.setLong(obj, jr.nextLong());
            } else if (fieldType.equals(int.class)) {
                field.setInt(obj, jr.nextInt());
            } else if (fieldType.equals(boolean.class)) {
                field.setBoolean(obj, jr.nextBoolean());
            } else if (fieldType.equals(String.class)) {
                field.set(obj, jr.nextString());
            } else {
                throw new RuntimeException("Unexpected: type: " + fieldType + ", name: " + name);
            }
        }
        jr.endObject();
    }
}
