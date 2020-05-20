package org.docksidestage.javatry.basic.st6.os;

/**
 * @author hieu
 */
public class St6Window extends St6OperationSystem{

    // ===================================================================================
    //                                                                      Constructor
    //                                                                      ==============
    public St6Window(String loginId) {
        super(loginId);
    }

    // ===================================================================================
    //                                                                      User Directory
    //                                                                      ==============
    @Override
    protected String getFileSeparator() {
        return "\\";
    }

    @Override
    protected String getUserDirectory() {
        return "/Users/" + this.getLoginId();
    }
}
