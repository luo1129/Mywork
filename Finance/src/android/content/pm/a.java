package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract class a extends Binder implements IPackageStatsObserver {
	public a() {
		attachInterface(this, "android.content.pm.IPackageStatsObserver");
	}

	public IBinder asBinder() {
		return this;
	}

	public boolean onTransact(int paramInt1, Parcel paramParcel1,
			Parcel paramParcel2, int paramInt2) throws RemoteException {
		switch (paramInt1) {
		case 1598968902:
			paramParcel2
					.writeString("android.content.pm.IPackageStatsObserver");
			return true;
		}
		paramParcel1
				.enforceInterface("android.content.pm.IPackageStatsObserver");
		PackageStats localPackageStats;
		if (paramParcel1.readInt() != 0) {
			localPackageStats = (PackageStats) PackageStats.CREATOR
					.createFromParcel(paramParcel1);
			if (paramParcel1.readInt() == 0) {
				onGetStatsCompleted(localPackageStats, true);
				localPackageStats = null;
				return true;
			}
		}

		return super.onTransact(paramInt1, paramParcel1, paramParcel2,
				paramInt2);
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: android.content.pm.a
 * 
 * JD-Core Version: 0.7.0.1
 */