
package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.clickit.demoseguro.Clases.DragRectView;
import com.frosquivel.magicalcamera.MagicalCamera;

import com.example.clickit.demoseguro.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by clickit on 23/08/16.
 */
public class CambiarAvatarFragment extends Fragment {

    private static String APP_DIRECTORY = "MyPictureApp/";
    private static String MEDIA_DIRECTORY = APP_DIRECTORY + "PictureApp";
    private CircleImageView imagecircle;
    private final int SELECT_PICTURE = 100;
    private final int PHOTO_CODE = 200;
    final static int cons  = 0;
    Bitmap bmp;
    private String mPath;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cambiar_avatar,container,false);
        imagecircle = (CircleImageView) view.findViewById(R.id.image_camera);
        /*activity = getActivity();
        magicalCamera = new MagicalCamera(activity,RESIZE_PHOTO_PIXELS_PERCENTAGE);
        */
        imagecircle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showOptions();
            }
        });
        /*final DragRectView view1 = (DragRectView)view.findViewById(R.id.dragRect);

        if (null != view1){
            view1.setOnUpCallback(new DragRectView.OnUpCallback() {
                @Override
                public void onRectFinished(Rect rect) {
                    Toast.makeText(getActivity().getApplicationContext(), "Rect is (" + rect.left + ", " + rect.top + ", " + rect.right + ", " + rect.bottom + ")",
                            Toast.LENGTH_LONG).show();
                }
            });
        }*/
        return view;
    }

    private void showOptions() {
        final CharSequence[] options = {"Tomar foto","Elegir de galeria","Cancelar"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Elige una opcion");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                switch (position){
                    case 0:
                        Log.e("TAG", "opcion " + position);
                        optionCamera();
                        break;
                    case 1:
                        Log.e("TAG", "opcion " + position);
                        /*Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("images/*");
                        startActivityForResult(intent.createChooser(intent,"Selecciona app de imagen"),SELECT_PICTURE);*/
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        //intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, SELECT_PICTURE);
                        break;
                    case 2:
                        Log.e("TAG", "opcion " + position);
                        dialogInterface.dismiss();
                        break;
                    default:
                        break;
                }
            }
        });
        builder.show();
    }

    private void optionCamera() {
        /**/
        File file = new File(Environment.getExternalStorageDirectory(),MEDIA_DIRECTORY);
        boolean isDirectoryCreated = file.exists();

        if (!isDirectoryCreated){
            isDirectoryCreated = file.mkdirs();
        }

        if (isDirectoryCreated){
            Long timestamp = System.currentTimeMillis() / 1000;
            String imageName = timestamp.toString() + ".jpg";

            mPath = Environment.getExternalStorageDirectory() +
                    File.separator +
                    MEDIA_DIRECTORY +
                    File.separator +
                    imageName;

            File newFile = new File(mPath);

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
            startActivityForResult(intent,PHOTO_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        /*magicalCamera.resultPhoto(requestCode, resultCode, data);
        imagecircle.setImageBitmap(magicalCamera.getMyPhoto());
        //magicalCamera.savePhotoInMemoryDevice(magicalCamera.getMyPhoto(), "myTestPhoto", MagicalCamera.JPEG, true);
        if(magicalCamera.savePhotoInMemoryDevice(magicalCamera.getMyPhoto(), "myTestPhoto", MagicalCamera.JPEG, true)){
            Toast.makeText(activity, "The photo is save", Toast.LENGTH_SHORT);
        }
        else {
            Toast.makeText(activity, "The photo isn't save",Toast.LENGTH_SHORT);
        }*/
        if (resultCode==Activity.RESULT_OK){
            switch (requestCode){
                case PHOTO_CODE:
                    MediaScannerConnection.scanFile(getActivity(),
                            new String[]{mPath}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.e("ExternalStorage", "Scanned " + path + ":");
                                    Log.e("ExternalStorage","-> Uri = " + uri);
                                }
                            });
                    Bitmap bitmap = BitmapFactory.decodeFile(mPath);
                    Log.e("QUE HAY",bitmap.toString());
                    imagecircle.setImageBitmap(bitmap);
                    break;
                case SELECT_PICTURE:
                    Uri path = data.getData();
                    try {
                        InputStream imageStream =getActivity().getContentResolver().openInputStream(path);
                        Bitmap yourImage = BitmapFactory.decodeStream(imageStream);
                        Log.e("QUE TRAJO",yourImage.toString());
                        //cropBitmap(yourImage,100,100);
                        imagecircle.setImageBitmap(yourImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    /*String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getActivity().getContentResolver().query(
                            path,filePathColumn,null,null,null);
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();

                    Bitmap yourImageSelected = BitmapFactory.decodeFile(filePath);*/

                    //imagecircle.setImageBitmap(yourImageSelected);
                    break;
            }
        }
    }

    public static Bitmap cropBitmap(Bitmap original,int height, int width){
        Bitmap croppedImage = Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565);

        Canvas canvas = new Canvas(croppedImage);

        Rect srcRect = new Rect(0,0,original.getWidth(),original.getHeight());
        Rect dstRect = new Rect(0,0,height,width);
        int dx = (srcRect.width()-dstRect.width())/2;
        int dy = (srcRect.height()-dstRect.height())/2;

        srcRect.inset(Math.max(0,dx),Math.max(0,dy));
        dstRect.inset(Math.max(0,dx),Math.max(0,dy));

        canvas.drawBitmap(original,srcRect,dstRect,null);
        original.recycle();
        return croppedImage;
    }
}
