package com.zzz.f;

import android.app.Activity;
import android.app.Application;
import java.util.ArrayList;
import java.util.Iterator;

public class ManageApplication
  extends Application
{
  private static ArrayList<Activity> activityList = new ArrayList();
  private static ManageApplication instance;
  
  public static ManageApplication getInstance()
  {
    if (instance == null) {
      instance = new ManageApplication();
    }
    return instance;
  }
  
  public static void returnBack()
  {
    int i = 0;
    Iterator localIterator = activityList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Activity localActivity = (Activity)localIterator.next();
      i++;
      if (i >= -4 + activityList.size()) {
        localActivity.finish();
      }
    }
  }
  
  public void addActivity(Activity paramActivity)
  {
    activityList.add(paramActivity);
  }
  
  public void exit()
  {
    Iterator localIterator = activityList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        System.exit(0);
        return;
      }
      ((Activity)localIterator.next()).finish();
    }
  }
}