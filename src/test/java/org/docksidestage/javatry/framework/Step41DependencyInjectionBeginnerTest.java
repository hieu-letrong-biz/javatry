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
package org.docksidestage.javatry.framework;

import org.docksidestage.bizfw.basic.objanimal.Animal;
import org.docksidestage.bizfw.basic.objanimal.Dog;
import org.docksidestage.bizfw.basic.supercar.SupercarDealer;
import org.docksidestage.bizfw.di.container.SimpleDiContainer;
import org.docksidestage.bizfw.di.usingdi.UsingDiAccessorAction;
import org.docksidestage.bizfw.di.usingdi.UsingDiAnnotationAction;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of Dependency Injection (DI) as beginner level. <br>
 * Show answer by log() or write answer on comment for question of javadoc.
 * @author jflute
 * @author your_name_here
 */
public class Step41DependencyInjectionBeginnerTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        Precondition
    //                                                                        ============
    /**
     * Search "Dependency Injection" by internet and learn it in thirty minutes. (study only) <br>
     * ("Dependency Injection" をインターネットで検索して、30分ほど学んでみましょう。(勉強のみ))
     */
    public void test_whatis_DependencyInjection() {
        // _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        // What is Dependency Injection?
        /** Learning Dependency Injection (DI) Note (by hieu 21/05/2020)
         *
         * To learn about DI, first we must understand where is it from
         * Start from the bigger to the smaller
         *              SOLID (an acronym for 5 important design principles when doing OOP)
         *           -> Dependency Inversion Principle (a principle to designing and writing code, D in SOLID)
         *           -> Inversion of Control (a design pattern to protect the ^DIP)
         *           -> Dependency Injection (a way to implement IoC, could be consider as a design pattern)
         *
         * Major concept of DI: The dependency module will be injected into the high level module.
         *
         * Why: Loose coupling code -> Easy to change
         *      Testability
         *      Clear dependency & Separate of concern
         *
         * How: 1. Modules do not communicate directly with each other, but through interfaces
         *      The low-level module will implement the interface, the high-level module will call the low-level module through the interface.
         *
         *      2. Initialization of low-level modules will be performed by DI Container.
         *      -> Difference: will not be performed by high-level modules
         *
         *      [comment] Sometimes, JavaConfig is also used instead of xml on spring framework case by subaru (2020/05/21)
         *      3. Which module attached to which interface will be configured in a particular file (XML as far as I know)
         *
         *      4. No need to create low-level module's instance in high-level module (Cuz its already there)
         *         All we need is just call it
         * Types: Constructor Injection, Setter Injection, Interface Injection
         *
         * Merits: In "Why section"
         *         Easy to test and maintenance
         *         Relationships between modules can be read (understand) easily in 1 file
         *
         * Defects: Hard to learn of course
         *          Also the complexity of code
         *          All object must be init from the begin, so IMP this will reduce performance
         *          "Easy to change" = "Hard to debug"
         *
         */
        //
        // _/_/_/_/_/_/_/_/_/_/
    }

    // ===================================================================================
    //                                                                 Non DI Code Reading
    //                                                                 ===================
    /**
     * What is the difference between NonDiDirectFirstAction and NonDiDirectSecondAction? <br>
     * (NonDiDirectFirstAction と NonDiDirectSecondAction の違いは？)
     */
    public void test_nondi_difference_between_first_and_second() {
        // your answer? => 
        /** (by hieu 21/05/2020)
         * The difference is, I think the SecondAction is the more-details version of FirstAction
         * Analyzed 3 methods callFriend(), wakeupMe() in Dog section and goToOffice() in Supercar section
         * I realized that: currently we want to change the object in FirstAction (to become more specific)
         * In details: Dog -> TooLazyDog, SupercarManufacturer's makesupercar method -> now defined in SupercarManufacturer class
         * Cause things've changed, so we must write more longer code
         *
         * Result is SecondAction representing the state that
         * the relationships between modules are become looser
         * or
         * High-level module is depends on low-level module (FirstAction)
         * Low-level module is now depends on High-level module (Second Action)
         */
        // and your confirmation code here freely
    }

    /**
     * What is the difference between NonDiDirectSecondAction and NonDiFactoryMethodAction? <br>
     * (NonDiDirectSecondAction と NonDiFactoryMethodAction の違いは？)
     */
    public void test_nondi_difference_between_second_and_FactoryMethod() {
        // your answer? =>
        /** (by hieu 21/05/2020)
         * Initialize process now moved to another function
         * The relationships between method are become looser
         * do() function now take less responsible for init() or create() works
         */
        // and your confirmation code here freely
    }

    /**
     * What is the difference between NonDiFactoryMethodAction and NonDiIndividualFactoryAction? <br>
     * (NonDiFactoryMethodAction と NonDiIndividualFactoryAction の違いは？)
     */
    public void test_nondi_difference_between_FactoryMethod_and_IndividualFactory() {
        // your answer? =>
        // TODO hieu consider about advantages and disadvantages of each design patterns by subaru (2020/05/21)
        /** (by hieu 21/05/2020)
         * Initialize process now moved to another class (NonDiAnimalFactory vs NonDiIndividualFactoryAction)
         * Each instance is created from it's class
         */
        // and your confirmation code here freely
    }

    // ===================================================================================
    //                                                               Using DI Code Reading
    //                                                               =====================
    /**
     * What is the difference between UsingDiAccessorAction and UsingDiAnnotationAction? <br>
     * (UsingDiAccessorAction と UsingDiAnnotationAction の違いは？)
     */
    public void test_usingdi_difference_between_Accessor_and_Annotation() {
        // your answer? =>
        // TODO hieu consider about advantages and disadvantages of each design patterns by subaru (2020/05/21)
        /**
         * Dependencies is injected via setter or via DI Container
         * (by hieu 21/05/2020)
         */
        // and your confirmation code here freely
        log("-----Using DI Accessor Action-----");
        UsingDiAccessorAction accessorAction = new UsingDiAccessorAction();
        accessorAction.setAnimal(new Dog());
        accessorAction.setSupercarDealer(new SupercarDealer());
        accessorAction.callFriend();

        log("\n-----Using DI Simple DI Container Action-----");
        SimpleDiContainer simpleDiContainer = SimpleDiContainer.getInstance(); // SimpleDiContainer is Singleton
        simpleDiContainer.registerModule(componentMap -> {
            componentMap.put(UsingDiAnnotationAction.class, new UsingDiAnnotationAction());
            componentMap.put(Animal.class, new Dog());
            componentMap.put(SupercarDealer.class, new SupercarDealer());
        });
        simpleDiContainer.resolveDependency();

        UsingDiAnnotationAction annotationAction = ((UsingDiAnnotationAction) simpleDiContainer.getComponent(UsingDiAnnotationAction.class));
        annotationAction.callFriend();
    }

    /**
     * What is the difference between UsingDiAnnotationAction and UsingDiDelegatingAction? <br>
     * (UsingDiAnnotationAction と UsingDiDelegatingAction の違いは？)
     */
    public void test_usingdi_difference_between_Annotation_and_Delegating() {
        // your answer? => 
        // and your confirmation code here freely
    }

    // ===================================================================================
    //                                                           Execute like WebFramework
    //                                                           =========================
    /**
     * Execute callFriend() of accessor action by UsingDiWebFrameworkProcess. <br>
     * (accessor の Action の callFriend() を UsingDiWebFrameworkProcess 経由で実行してみましょう)
     */
    public void test_usingdi_UsingDiWebFrameworkProcess_callfriend_accessor() {
        // execution code here
    }

    /**
     * Execute callFriend() of annotation and delegating actions by UsingDiWebFrameworkProcess.
     * (And you can increase hit-points of sleepy cat in this method) <br>
     * (annotation, delegating の Action の callFriend() を UsingDiWebFrameworkProcess 経由で実行してみましょう。
     * (眠い猫のヒットポイントをこのメソッド内で増やしてもOK))
     */
    public void test_usingdi_UsingDiWebFrameworkProcess_callfriend_annotation_delegating() {
        // execution code here
    }

    /**
     * What is concrete class of instance variable "animal" of UsingDiAnnotationAction? (when registering UsingDiModule) <br>
     * (UsingDiAnnotationAction のインスタンス変数 "animal" の実体クラスは？ (UsingDiModuleを登録した時))
     */
    public void test_usingdi_whatis_animal() {
        // your answer? => 
        // and your confirmation code here freely
    }

    // ===================================================================================
    //                                                                        DI Container
    //                                                                        ============
    /**
     * What is DI container? <br>
     * (DIコンテナとは？)
     */
    public void test_whatis_DIContainer() {
        // your answer? => 
        // and your confirmation code here freely
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * What is class or file of DI settings that defines MemberBhv class as DI component in the following Lasta Di application? <br>
     * (以下のLasta DiアプリケーションでMemberBhvクラスをDIコンポーネントとして定義しているDI設定クラスもしくはファイルは？) <br>
     *
     * https://github.com/lastaflute/lastaflute-example-harbor
     */
    public void test_zone_search_component_on_LastaDi() {
        // your answer? => 
    }

    /**
     * What is class or file of DI settings that defines MemberBhv class as DI component in the following Spring application? <br>
     * (以下のSpringアプリケーションでMemberBhvクラスをDIコンポーネントとして定義しているDI設定クラスもしくはファイルは？) <br>
     *
     * https://github.com/dbflute-example/dbflute-example-on-springboot
     */
    public void test_zone_search_component_on_Spring() {
        // your answer? => 
    }
}
