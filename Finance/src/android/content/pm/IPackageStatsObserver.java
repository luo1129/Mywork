package android.content.pm;

import android.os.IInterface;

public abstract interface IPackageStatsObserver
  extends IInterface
{
  public abstract void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean);
}


/* Location:           C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name:     android.content.pm.IPackageStatsObserver
 * JD-Core Version:    0.7.0.1
 */