/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\workspace\\RemoteService\\app\\src\\main\\aidl\\de\\hsos\\sawida\\remoteservice\\IMyRemoteService.aidl
 */
package de.hsos.sawida.remoteservice;
public interface IMyRemoteService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.hsos.sawida.remoteservice.IMyRemoteService
{
private static final java.lang.String DESCRIPTOR = "de.hsos.sawida.remoteservice.IMyRemoteService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an de.hsos.sawida.remoteservice.IMyRemoteService interface,
 * generating a proxy if needed.
 */
public static de.hsos.sawida.remoteservice.IMyRemoteService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.hsos.sawida.remoteservice.IMyRemoteService))) {
return ((de.hsos.sawida.remoteservice.IMyRemoteService)iin);
}
return new de.hsos.sawida.remoteservice.IMyRemoteService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getCounter:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCounter();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.hsos.sawida.remoteservice.IMyRemoteService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public int getCounter() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCounter, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getCounter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public int getCounter() throws android.os.RemoteException;
}
