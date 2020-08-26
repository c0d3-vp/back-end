package com.lambdaschool.notapotluck.models;

import javax.validation.constraints.Email;

/**
 * A model used to create a new user. The minimum information needed to create a user.
 * Note the role will default to USER.
 */
public class UserMinimum
{
    private String username;

    private String password;

    private String primaryemail;

    public UserMinimum()
    {
    }

    public UserMinimum(
        String username,
        String password,
        String primaryemail)
    {
        this.username = username;
        this.password = password;
        this.primaryemail = primaryemail;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPrimaryemail()
    {
        return primaryemail;
    }
    public void setPrimaryemail(String primaryemail)
    {
        this.primaryemail = primaryemail;
    }
}

