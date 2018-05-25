/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Tue Aug 28 18:29:29 CST 2007 by MyEclipse Hibernate Tool.
 */
package com.demo.hibernate.beans;

import java.io.Serializable;

/**
 * A class that represents a row in the schedule table. 
 * You can customize the behavior of this class by editing the class, {@link Schedule()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractSchedule 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Integer id;

    /** The value of the simple username property. */
    private java.lang.String username;

    /** The value of the simple year property. */
    private java.lang.Integer year;

    /** The value of the simple month property. */
    private java.lang.Integer month;

    /** The value of the simple day property. */
    private java.lang.Integer day;

    /** The value of the simple plan property. */
    private java.lang.String plan;

    /**
     * Simple constructor of AbstractSchedule instances.
     */
    public AbstractSchedule()
    {
    }

    /**
     * Constructor of AbstractSchedule instances given a simple primary key.
     * @param id
     */
    public AbstractSchedule(java.lang.Integer id)
    {
        this.setId(id);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getId()
    {
        return id;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param id
     */
    public void setId(java.lang.Integer id)
    {
        this.hashValue = 0;
        this.id = id;
    }

    /**
     * Return the value of the username column.
     * @return java.lang.String
     */
    public java.lang.String getUsername()
    {
        return this.username;
    }

    /**
     * Set the value of the username column.
     * @param username
     */
    public void setUsername(java.lang.String username)
    {
        this.username = username;
    }

    /**
     * Return the value of the year column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getYear()
    {
        return this.year;
    }

    /**
     * Set the value of the year column.
     * @param year
     */
    public void setYear(java.lang.Integer year)
    {
        this.year = year;
    }

    /**
     * Return the value of the month column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getMonth()
    {
        return this.month;
    }

    /**
     * Set the value of the month column.
     * @param month
     */
    public void setMonth(java.lang.Integer month)
    {
        this.month = month;
    }

    /**
     * Return the value of the day column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getDay()
    {
        return this.day;
    }

    /**
     * Set the value of the day column.
     * @param day
     */
    public void setDay(java.lang.Integer day)
    {
        this.day = day;
    }

    /**
     * Return the value of the plan column.
     * @return java.lang.String
     */
    public java.lang.String getPlan()
    {
        return this.plan;
    }

    /**
     * Set the value of the plan column.
     * @param plan
     */
    public void setPlan(java.lang.String plan)
    {
        this.plan = plan;
    }

    /**
     * Implementation of the equals comparison on the basis of equality of the primary key values.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof Schedule))
            return false;
        Schedule that = (Schedule) rhs;
        if (this.getId() == null || that.getId() == null)
            return false;
        return (this.getId().equals(that.getId()));
    }

    /**
     * Implementation of the hashCode method conforming to the Bloch pattern with
     * the exception of array properties (these are very unlikely primary key types).
     * @return int
     */
    public int hashCode()
    {
        if (this.hashValue == 0)
        {
            int result = 17;
            int idValue = this.getId() == null ? 0 : this.getId().hashCode();
            result = result * 37 + idValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}