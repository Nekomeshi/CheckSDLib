package com.nekomeshi312.checksdlib;

import android.content.Context;
import android.os.Environment;

public class SDCardAccess {
	public static final int NO_ERROR = 0;
	/**
	 * SDカードの状態を調べる。書き込み不可の場合はエラーメッセージをToastに表示する
	 * @param context
	 * @return
	 * 0:書き込み可能　
	 * それ以外：エラーメッセージを示すリソースID
	 */
	public static int checkSDCard(Context context){
		String status = Environment.getExternalStorageState();
		int errorMsgID;
		if (status.equalsIgnoreCase(Environment.MEDIA_MOUNTED)){
			return NO_ERROR;
		}
		else if (status.equalsIgnoreCase(Environment.MEDIA_MOUNTED_READ_ONLY)){
			errorMsgID = R.string.SDCardReadOnly;
		}
		else if (status.equalsIgnoreCase(Environment.MEDIA_REMOVED)){
			errorMsgID = R.string.SDCardRemoved;
		}
		else if (status.equalsIgnoreCase(Environment.MEDIA_SHARED)){
			errorMsgID = R.string.SDCardShared;
		}
		else if (status.equalsIgnoreCase(Environment.MEDIA_BAD_REMOVAL)){
			errorMsgID = R.string.SDCardBadRemoval;
		}
		else if (status.equalsIgnoreCase(Environment.MEDIA_CHECKING)){
			errorMsgID = R.string.SDCardChecking;
		}
		else if (status.equalsIgnoreCase(Environment.MEDIA_NOFS)){
			errorMsgID = R.string.SDCardNOFS;
		}
		else if (status.equalsIgnoreCase(Environment.MEDIA_UNMOUNTABLE)){
			errorMsgID = R.string.SDCardUnMountable;
		}
		else if (status.equalsIgnoreCase(Environment.MEDIA_UNMOUNTED)){
			errorMsgID = R.string.SDCardUnMounted;
		}
		else{
			errorMsgID = R.string.SDCardUnknownError;
		}
		return errorMsgID;
	}	
}
