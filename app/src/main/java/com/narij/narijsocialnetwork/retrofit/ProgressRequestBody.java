package com.narij.narijsocialnetwork.retrofit;

import android.os.Handler;
import android.os.Looper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * Created by kami on 2/17/2018.
 */

public class ProgressRequestBody extends RequestBody {

    private File mFile;
    private String mPath;
    private UploadCallbacks mListener;

    private static final int DEFAULT_BUFFER_SIZE = 2048;

    private boolean prog = false;

    public interface UploadCallbacks {
        void onProgressUpdate(int percentage);

        void onError();

        void onFinish();
    }

    public ProgressRequestBody(final File file, final UploadCallbacks listener) {
        mFile = file;
        mListener = listener;
    }


    @Override
    public MediaType contentType() {
        return MediaType.parse("image/*");
    }

    @Override
    public long contentLength() throws IOException {
        return mFile.length();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {

        long fileLength = mFile.length();
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        FileInputStream in = new FileInputStream(mFile);
        long uploaded = 0;

        try {
            int read;
            Handler handler = new Handler(Looper.getMainLooper());
            while ((read = in.read(buffer)) != -1) {

                // update progress on UI thread

                //Log.d(Globals.LOG_TAG, "U : " + uploaded);

                uploaded += read;
                sink.write(buffer, 0, read);
                if (prog == true)
                    handler.post(new ProgressUpdater(uploaded, fileLength));
            }
            if (prog == true)
                handler.post(new ProgressUpdater(fileLength, fileLength));
            prog = true;

        } finally {
            in.close();
        }
    }


    private class ProgressUpdater implements Runnable {
        private long mUploaded;
        private long mTotal;

        public ProgressUpdater(long uploaded, long total) {
            mUploaded = uploaded;
            mTotal = total;
//            Log.d(Globals.LOG_TAG, total +  " of " + uploaded);

        }

        @Override
        public void run() {
//            Log.d(Globals.LOG_TAG, "P : " + ((int) (100 * mUploaded / mTotal)));
            mListener.onProgressUpdate((int) (100 * mUploaded / mTotal));
        }
    }

}
