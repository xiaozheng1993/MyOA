/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Tue Aug 28 18:29:30 CST 2007 by MyEclipse Hibernate Tool.
 */
package com.demo.hibernate.beans;

import java.io.Serializable;

/**
 * A class that represents a row in the worklog table. 
 * You can customize the behavior of this class by editing the class, {@link Worklog()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractWorklog 
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

    /** The value of the simple title property. */
    private java.lang.String title;

    /** The value of the simple description property. */
    private java.lang.String description;

    /** The value of the simple logtime property. */
    private java.lang.String logtime;
    private java.lang.String time;


    /**
     * Simple constructor of AbstractWorklog instances.
     */
    public AbstractWorklog()
    {
    }

    /**
     * Constructor of AbstractWorklog instances given a simple primary key.
     * @param id
     */
    public AbstractWorklog(java.lang.Integer id)
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
     * Return the value of the title column.
     * @return java.lang.String
     */
    public java.lang.String getTitle()
    {
        return this.title;
    }

    /**
     * Set the value of the title column.
     * @param title
     */
    public void setTitle(java.lang.String title)
    {
        this.title = title;
    }

    /**
     * Return the value of the description column.
     * @return java.lang.String
     */
    public java.lang.String getDescription()
    {
        return this.description;
    }

    /**
     * Set the value of the description column.
     * @param description
     */
    public void setDescription(java.lang.String description)
    {
        this.description = description;
    }

    /**
     * Return the value of the logtime column.
     * @return java.lang.String
     */
    public java.lang.String getLogtime()
    {
        return this.logtime;
    }

    /**
     * Set the value of the logtime column.
     * @param logtime
     */
    public void setLogtime(java.lang.String logtime)
    {
        this.logtime = logtime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
        if (! (rhs instanceof Worklog))
            return false;
        Worklog that = (Worklog) rhs;
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
