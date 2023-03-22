package org.example.file.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {

    private final int chunkLength;
    private final static String RESOURSE_PATH = new File("").getAbsolutePath() + "/lesson-4/src/main/resources/";

    public Sorter(int chunkLength) {
        this.chunkLength = chunkLength;
    }

    public File sortFile(File dataFile) throws IOException {
        int fileNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
            String readedLine;
            while ((readedLine = br.readLine()) != null) {
                List<Long> chunk = getChunk(br, readedLine);
                Collections.sort(chunk);
                fileNumber++;
                saveChunk(fileNumber, chunk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        double iter = Math.log(fileNumber) / Math.log(2);
        for (int i = 1; i <= iter + 1; i++) {
            for (int j = 1; j <= fileNumber / (Math.pow(2, i)) + 1; j++) {
                if (!new File(RESOURSE_PATH + i + "-" + (2 * j - 1) + ".txt").exists()) {
                    PrintWriter pw = new PrintWriter(new FileWriter(RESOURSE_PATH + i + "-" + (2 * j - 1) + ".txt"));
                    pw.close();
                }
                if (!new File(RESOURSE_PATH + i + "-" + (2 * j) + ".txt").exists()) {
                    PrintWriter pw = new PrintWriter(new FileWriter(RESOURSE_PATH + i + "-" + 2 * j + ".txt"));
                    pw.close();
                }
                try (BufferedReader br1 = new BufferedReader(new FileReader(RESOURSE_PATH + i + "-" + (2 * j - 1) + ".txt"));
                     BufferedReader br2 = new BufferedReader(new FileReader(RESOURSE_PATH + i + "-" + 2 * j + ".txt"))) {
                    long number1 = 0;
                    long number2 = 0;
                    String readedLine1;
                    String readedLine2;
                    String nextFileName = RESOURSE_PATH + (i + 1) + "-" + j + ".txt";
                    try (PrintWriter pw = new PrintWriter(new FileWriter(nextFileName))) {
                        boolean isOneEmpty = false;
                        boolean isTwoEmpty = false;
                        if ((readedLine1 = br1.readLine()) != null) {
                            number1 = Long.decode(readedLine1);
                        } else {
                            isOneEmpty = true;
                        }
                        if ((readedLine2 = br2.readLine()) != null) {
                            number2 = Long.decode(readedLine2);
                        } else {
                            if (i == 1 && j == 1) {
                                return new File(RESOURSE_PATH + i + "-" + 1 + ".txt");
                            } else {
                                isTwoEmpty = true;
                            }
                        }
                        while (!isOneEmpty) {
                            if (isTwoEmpty) {
                                pw.println(number1);
                                while ((readedLine1 = br1.readLine()) != null) {
                                    number1 = Long.decode(readedLine1);
                                    pw.println(number1);
                                }
                                break;
                            }
                            if (number1 < number2) {
                                pw.println(number1);
                                if ((readedLine1 = br1.readLine()) != null) {
                                    number1 = Long.decode(readedLine1);
                                } else {
                                    isOneEmpty = true;
                                }
                            } else if (number1 > number2) {
                                pw.println(number2);
                                if ((readedLine2 = br2.readLine()) != null) {
                                    number2 = Long.decode(readedLine2);
                                } else {
                                    isTwoEmpty = true;
                                }
                            } else {
                                pw.println(number1);
                                pw.println(number2);
                                if ((readedLine1 = br1.readLine()) != null) {
                                    number1 = Long.decode(readedLine1);
                                } else {
                                    isOneEmpty = true;
                                }
                                if ((readedLine2 = br2.readLine()) != null) {
                                    number2 = Long.decode(readedLine2);
                                } else {
                                    isTwoEmpty = true;
                                }
                            }
                            if (isOneEmpty && !isTwoEmpty) {
                                pw.println(number2);
                                while ((readedLine2 = br2.readLine()) != null) {
                                    number2 = Long.decode(readedLine2);
                                    pw.println(number2);
                                }
                                isTwoEmpty = true;
                            }
                        }
                        pw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new File(RESOURSE_PATH + i + "-" + (2 * j - 1) + ".txt").delete();
                new File(RESOURSE_PATH + i + "-" + 2 * j + ".txt").delete();
            }
        }
        if (iter >= 0) {
            return new File(RESOURSE_PATH + (int) (iter + 2) + "-" + 1 + ".txt");
        } else throw new EmptyDataFileExeption("Файл для сортировки пустой");
    }

    private void saveChunk(int fileNumder, List<Long> chunk) {
        String fileName = RESOURSE_PATH + 1 + "-" + fileNumder + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (Long element : chunk) {
                pw.println(element);
            }
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Long> getChunk(BufferedReader br, String readedLine) throws IOException {
        int i = 1;
        List<Long> chunk = new ArrayList<>();
        chunk.add(Long.decode(readedLine));
        while (i < chunkLength && (readedLine = br.readLine()) != null) {
            i++;
            chunk.add(Long.decode(readedLine));
        }
        return chunk;
    }
}
