/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.colorbox;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.docksidestage.bizfw.colorbox.ColorBox;
import org.docksidestage.bizfw.colorbox.yours.YourPrivateRoom;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of String with color-box, using Stream API you can. <br>
 * Show answer by log() for question of javadoc.
 * @author jflute
 * @author hieu
 */
public class Step12StreamStringTest extends PlainTestCase {

    // ===================================================================================
    //                                                                            length()
    //                                                                            ========
    /**
     * What is color name length of first color-box? <br>
     * (最初のカラーボックスの色の名前の文字数は？)
     */
    public void test_length_basic() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String answer = colorBoxList.stream()
                .findFirst()
                .map(colorBox -> colorBox.getColor().getColorName())
                .map(colorName -> colorName.length() + " (" + colorName + ")")
                .orElse("*not found");
        log(answer); // 5 (green). OK
    }

    /**
     * Which string has max length in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長い文字列は？)
     */
    public void test_length_findMax() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String answer = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .flatMap(boxSpace -> boxSpace.stream())
                .map(boxSpace -> boxSpace.getContent())
                .filter(content -> content instanceof String)
                .map(stringContent -> String.valueOf(stringContent))
                .max(Comparator.comparingInt(String::length))
                .orElse("*not found");
        log(answer); // おるぐどっくさいどすてーじ
    }

    /**
     * How many characters are difference between max and min length of string in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長いものと短いものの差は何文字？)
     */
    public void test_length_findMaxMinDiff() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        List<Integer> lengthArray = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .flatMap(boxSpace -> boxSpace.stream())
                .map(boxSpace -> boxSpace.getContent())
                .filter(content -> content instanceof String)
                .map(stringContent -> String.valueOf(stringContent))
                .map(stringContent -> stringContent.length())
                .sorted()
                .collect(Collectors.toList());

        log(lengthArray.get(lengthArray.size() - 1) - lengthArray.get(0)); // 3 OK
    }

    // has small #adjustmemts from ClassicStringTest
    //  o sort allowed in Stream
    /**
     * Which value (toString() if non-string) has second-max length in color-boxes? (sort allowed in Stream)<br>
     * (カラーボックスに入ってる値 (文字列以外はtoString()) の中で、二番目に長い文字列は？ (Streamでのソートありで))
     */
    public void test_length_findSecondMax() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        List<String> contents = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .flatMap(boxSpace -> boxSpace.stream())
                .map(boxSpace -> boxSpace.getContent())
                .map(stringContent -> String.valueOf(stringContent))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        int contentsSize = contents.size();
        String answer = contentsSize > 2 ? contents.get(contentsSize - 2) : "Not found";
        log(answer); // {sea={dockside=[over, table, hello], hanger=[mystic, shadow, mirage], harbor={spring=fashion, summer=pirates,
        // autumn=vi, winter=jazz}}, land={orleans=[oh, party], showbase=[oneman]}}
    }

    /**
     * How many total lengths of strings in color-boxes? <br>
     * (カラーボックスに入ってる文字列の長さの合計は？)
     */
    public void test_length_calculateLengthSum() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        Integer lengthSum = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .flatMap(boxSpace -> boxSpace.stream())
                .map(boxSpace -> boxSpace.getContent())
                .filter(content -> content instanceof String)
                .map(stringContent -> String.valueOf(stringContent))
                .map(stringLength -> stringLength.length())
                .reduce(0, (current, next) -> current + next);
        log(lengthSum); //23 OK
    }

    /**
     * Which color name has max length in color-boxes? <br>
     * (カラーボックスの中で、色の名前が一番長いものは？)
     */
    public void test_length_findMaxColorSize() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String maxSizeColorName = colorBoxList.stream()
                .map(colorBox -> colorBox.getColor())
                .map(boxColorName -> boxColorName.getColorName())
                .max(Comparator.comparingInt(String::length))
                .orElse("*not found");
        log(maxSizeColorName); //yellow
    }

    // ===================================================================================
    //                                                            startsWith(), endsWith()
    //                                                            ========================
    /**
     * What is color in the color-box that has string starting with "Water"? <br>
     * ("Water" で始まる文字列をしまっているカラーボックスの色は？)
     */
    public void test_startsWith_findFirstWord() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        List<String> boxColorStartWithWater = colorBoxList.stream()
                .filter(colorBox -> colorBox.getSpaceList()
                        .stream()
                        .map(boxSpace -> boxSpace.getContent())
                        .filter(content -> content instanceof String)
                        .map(content -> String.valueOf(content))
                        .anyMatch(content -> content.startsWith("Water")))
                .map(colorBox -> colorBox.getColor().getColorName())
                .collect(Collectors.toList());

        for (int i = 0; i < boxColorStartWithWater.size(); i++) {
            log(boxColorStartWithWater.get(i));
        }
        // awswer: red
    }

    /**
     * What is color in the color-box that has string ending with "front"? <br>
     * ("front" で終わる文字列をしまっているカラーボックスの色は？)
     */
    public void test_endsWith_findLastWord() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        List<String> boxColorEndWithFront = colorBoxList.stream()
                .filter(colorBox -> colorBox.getSpaceList()
                        .stream()
                        .map(boxSpace -> boxSpace.getContent())
                        .filter(content -> content instanceof String)
                        .map(content -> String.valueOf(content))
                        .anyMatch(content -> content.endsWith("front")))
                .map(colorBox -> colorBox.getColor().getColorName())
                .collect(Collectors.toList());

        for (int i = 0; i < boxColorEndWithFront.size(); i++) {
            log(boxColorEndWithFront.get(i));
        }
        // awswer: red
    }

    // ===================================================================================
    //                                                            indexOf(), lastIndexOf()
    //                                                            ========================
    /**
     * What number character is starting with first "front" of string ending with "front" in color-boxes? <br>
     * (カラーボックスに入ってる "front" で終わる文字列で、最初の "front" は何文字目から始まる？)
     */
    public void test_indexOf_findIndex() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int answer = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .flatMap(boxSpace -> boxSpace.stream())
                .map(content -> content.getContent())
                .filter(content -> content instanceof String)
                .map(content -> String.valueOf(content))
                .filter(content -> content.endsWith("front"))
                .findFirst()
                .orElse("not found")
                .indexOf("front");
        log(answer); //5
    }

    /**
     * What number character is starting with the late "ど" of string containing plural "ど"s in color-boxes? (e.g. "どんどん" => 3) <br>
     * (カラーボックスに入ってる「ど」を二つ以上含む文字列で、最後の「ど」は何文字目から始まる？ (e.g. "どんどん" => 3))
     */
    public void test_lastIndexOf_findIndex() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int answer = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .flatMap(boxSpace -> boxSpace.stream())
                .map(content -> content.getContent())
                .filter(content -> content instanceof String)
                .map(content -> String.valueOf(content))
                .filter(content -> {
                    int count = 0;
                    for (int i = 0; i < content.length(); i++) {
                        if (content.charAt(i) == 'ど')
                            ++count;
                        if (count >= 2)
                            return true;
                    }
                    return false;
                })
                .findFirst()
                .orElse("not found")
                .lastIndexOf("ど");
        log(answer); //8
    }

    // ===================================================================================
    //                                                                         substring()
    //                                                                         ===========
    /**
     * What character is first of string ending with "front" in color-boxes? <br>
     * (カラーボックスに入ってる "front" で終わる文字列の最初の一文字は？)
     */
    public void test_substring_findFirstChar() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String answer = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .flatMap(boxSpace -> boxSpace.stream())
                .map(content -> content.getContent())
                .filter(content -> content instanceof String)
                .map(content -> String.valueOf(content))
                .filter(content -> content.endsWith("front"))
                .findFirst()
                .orElse("not found");
        log(answer.equals("not found") ? "not found" : answer.charAt(0)); //W
    }

    /**
     * What character is last of string starting with "Water" in color-boxes? <br>
     * (カラーボックスに入ってる "Water" で始まる文字列の最後の一文字は？)
     */
    public void test_substring_findLastChar() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String answer = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .flatMap(boxSpace -> boxSpace.stream())
                .map(content -> content.getContent())
                .filter(content -> content instanceof String)
                .map(content -> String.valueOf(content))
                .filter(content -> content.startsWith("Water"))
                .findFirst()
                .orElse("not found");
        log(answer.equals("not found") ? "not found" : answer.charAt(answer.length() - 1)); //t
    }

    // ===================================================================================
    //                                                                           replace()
    //                                                                           =========
    /**
     * How many characters does string that contains "o" in color-boxes and removing "o" have? <br>
     * (カラーボックスに入ってる "o" (おー) を含んだ文字列から "o" を全て除去したら何文字？)
     */
    public void test_replace_remove_o() {
    }

    /**
     * What string is path string of java.io.File in color-boxes, which is replaced with "/" to Windows file separator? <br>
     * カラーボックスに入ってる java.io.File のパス文字列のファイルセパレーターの "/" を、Windowsのファイルセパレーターに置き換えた文字列は？
     */
    public void test_replace_fileseparator() {
    }

    // ===================================================================================
    //                                                                    Welcome to Devil
    //                                                                    ================
    /**
     * What is total length of text of DevilBox class in color-boxes? <br>
     * (カラーボックスの中に入っているDevilBoxクラスのtextの長さの合計は？)
     */
    public void test_welcomeToDevil() {
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * What string is converted to style "map:{ key = value ; key = value ; ... }" from java.util.Map in color-boxes? <br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = value ; ... }" という形式で表示すると？)
     */
    public void test_showMap_flat() {
    }

    /**
     * What string is converted to style "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" from java.util.Map in color-boxes? <br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" という形式で表示すると？)
     */
    public void test_showMap_nested() {
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    // has small #adjustmemts from ClassicStringTest
    //  o comment out because of too difficult to be stream?
    ///**
    // * What string of toString() is converted from text of SecretBox class in upper space on the "white" color-box to java.util.Map? <br>
    // * (whiteのカラーボックスのupperスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
    // */
    //public void test_parseMap_flat() {
    //}
    //
    ///**
    // * What string of toString() is converted from text of SecretBox class in both middle and lower spaces on the "white" color-box to java.util.Map? <br>
    // * (whiteのカラーボックスのmiddleおよびlowerスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
    // */
    //public void test_parseMap_nested() {
    //}
}
