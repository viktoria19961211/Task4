package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static List<Integer> array;

    public static void main(String[] args) {

        System.out.println("Введите путь к файлу:");
        array = getArray(new Scanner(System.in).nextLine());

        int count = 0;
        int min = Integer.MAX_VALUE;
        Integer[] temp = array.toArray(new Integer[array.size()]);

        for (int i = 0; i < temp.length; i++) {
            count = 0;
            Integer[] massiv = Arrays.copyOf(temp, temp.length);
            for (int j = 0; j < massiv.length; j++) {
                while (massiv[i] != massiv[j]) {
                    if (massiv[i] > massiv[j]) {
                        ++count;
                        massiv[j] += 1;
                    } else if (massiv[i] < massiv[j]) {
                        ++count;
                        massiv[j] -= 1;
                    }
                }
            }
            if (count < min) {
                min = count;
            }
        }
        System.out.println(min);
    }

    public static List<Integer> getArray(String path) {
        List<Integer> array = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            String regex = "[\s+0-9]";
            while ((line = br.readLine()) != null) {
                if (line.replaceAll(regex, "").trim().isEmpty()) {
                    array.add(Integer.parseInt(line.trim()));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла " + path);
            e.getMessage();
        }
        return array;
    }

}