package de.hsos.sawida.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {

	private Handler serviceHandler;
	private int counter;
	private Task myTask = new Task();


	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(getClass().getSimpleName(), "onBind()");
		return myRemoteServiceStub;
	}

	private IMyRemoteService.Stub myRemoteServiceStub = new IMyRemoteService.Stub() {
		public int getCounter() throws RemoteException {
			return counter;
		}
	};
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(getClass().getSimpleName(),"onCreate()");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		serviceHandler.removeCallbacks(myTask);
		serviceHandler = null;
		Log.d(getClass().getSimpleName(),"onDestroy()");
	}

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        serviceHandler = new Handler();
        serviceHandler.postDelayed(myTask, 1000L);
        Log.d(getClass().getSimpleName(), "onStart()");
        return super.onStartCommand(intent, flags, startId);
    }

	class Task implements Runnable {
		public void run() {
			++counter;
			serviceHandler.postDelayed(this,1000L);
			Log.i(getClass().getSimpleName(), "Incrementing counter in the run method");
		}
	}
}
