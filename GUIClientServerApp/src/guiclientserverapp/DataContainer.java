/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclientserverapp;

import java.io.Serializable;

/**
 *
 * @author Ronald Joubert
 */
public class DataContainer implements Serializable{
    private String objectName;
    private int dataType;
    private int returnType;
    
    public static final int CUSTOMER = 0;
    public static final int PRODUCT = 1;
    

    /**
     * @return the objectName
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * @param objectName the objectName to set
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /**
     * @return the dataType
     */
    public int getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the returnType
     */
    public int getReturnType() {
        return returnType;
    }

    /**
     * @param returnType the returnType to set
     */
    public void setReturnType(int returnType) {
        this.returnType = returnType;
    }

   
}
