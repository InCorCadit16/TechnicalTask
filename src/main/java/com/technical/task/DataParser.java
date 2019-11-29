package com.technical.task;

public class DataParser {
    private static final String QUOTE = ",";

    static Record parse(String data) {
        Record record = new Record();

        StringBuilder dataBuilder = new StringBuilder(data);

        record.setA(getDataAndRemove(dataBuilder));
        record.setB(getDataAndRemove(dataBuilder));
        record.setC(getDataAndRemove(dataBuilder));
        record.setD(getDataAndRemove(dataBuilder));

        // parse base64 image separately
        String s = dataBuilder.substring(0, dataBuilder.lastIndexOf("\"") + 1);
        dataBuilder.delete(0, dataBuilder.lastIndexOf("\"") + 2);
        record.setE(s);

        record.setF(getDataAndRemove(dataBuilder));
        record.setG(getDataAndRemove(dataBuilder));
        record.setH(getDataAndRemove(dataBuilder));
        record.setI(getDataAndRemove(dataBuilder));
        record.setJ(getDataAndRemove(dataBuilder));
        return record;
}

    private static String getDataAndRemove(StringBuilder dataBuilder) {
        String s;
        if (dataBuilder.indexOf(QUOTE) == -1) {
            s = dataBuilder.toString();
        } else {
            s = dataBuilder.substring(0, dataBuilder.indexOf(QUOTE));
            dataBuilder.delete(0, dataBuilder.indexOf(QUOTE) + 1);
        }

        return s;
    }
}
