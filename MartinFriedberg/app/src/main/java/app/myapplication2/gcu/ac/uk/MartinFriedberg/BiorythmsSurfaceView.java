package app.myapplication2.gcu.ac.uk.MartinFriedberg;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Martin on 16/12/2014.
 */
public class BiorythmsSurfaceView extends SurfaceView implements SurfaceHolder.Callback
{
    private SurfaceHolder shBioSurface;

    BiorythmsThread drawingThread = null;


    public BiorythmsSurfaceView(Context context)
    {
        super(context);
        shBioSurface = getHolder();
        shBioSurface.addCallback(this);
        drawingThread = new BiorythmsThread(getHolder(), this);
        setFocusable(true);

    }

    public BiorythmsThread getThread()
    {
        return drawingThread;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {

        drawingThread.setRunning(true);
        drawingThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {
        drawingThread.setSurfaceSize(width,height);

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        drawingThread.setRunning(false);
        while(retry)
        {
            try {
                drawingThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}