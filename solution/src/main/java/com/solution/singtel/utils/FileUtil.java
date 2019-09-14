package com.solution.singtel.utils;

import com.solution.singtel.common.SolutionException;
import org.apache.maven.shared.utils.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author ankitkumarjain
 * @version $Id: FileUtil.java, v 0.1 2019-09-12 6:09 PM ankitkumarjain Exp $$
 */
public class FileUtil {

    /**
     * This method is to get bufferReader for a file of provided path.
     *
     * @param filePath
     * @return
     * @throws SolutionException
     */
    public static BufferedReader getFileBufferedReader(String filePath) throws SolutionException {

        // basic validation
        AssertUtil.notBlank(filePath, "filepath provided to read should not be blank");

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (Throwable t) {
            throw new SolutionException("fileReader failed for path " + filePath + "; " + t.getMessage(), t);
        }

        // creating BufferedReader object for the file.
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        return bufferedReader;
    }


    /**
     * get the next non-empty line from the bufferedReader
     *
     * @param bufferedReader
     * @return
     * @throws Exception
     */
    public static String getNextLine(BufferedReader bufferedReader, String filePath) throws SolutionException {

        try {
            String line = bufferedReader.readLine();

            while (true) {
                if (line == null || !StringUtils.isBlank(line)) {
                    return line;
                }
                line = bufferedReader.readLine();
            }
        } catch (Throwable t) {
            throw new SolutionException("failed to read line for path " + "; " + filePath + t.getMessage(), t);
        }
    }

}