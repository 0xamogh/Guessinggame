package amoghjapps.com.guessinggame;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.icu.text.UnicodeSetSpanner;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.List;
import java.util.Random;

import amoghjapps.com.guessinggame.JSONResponses.Response;
import amoghjapps.com.guessinggame.JSONResponses.Tag;
import retrofit2.Call;
import retrofit2.Callback;

public class guessingactivity extends AppCompatActivity {
    Button op1,op2,op3,op4;
    TextView counter;
    ImageView view;
    public int randomizer;
    public         List<Tag> list;
    String comparer;
    int counter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guessingactivity);
        op1=findViewById(R.id.option1);
        op2=findViewById(R.id.option2);
        op3=findViewById(R.id.option3);
        op4=findViewById(R.id.option4);
        counter=findViewById(R.id.counter);
        view=findViewById(R.id.imageView);
        Intent intent = getIntent();
        Uri passedUri= Uri.parse(intent.getExtras().getString("uri"));
        counter.setText(passedUri.toString());

            view.setImageURI(passedUri);


        String baseUrl="https://api.imagga.com/v2/";
        String path=getRealPathFromURI(getApplicationContext(),passedUri);
        Toast.makeText(getApplicationContext(),path,Toast.LENGTH_LONG).show();

        // converting image to bytearray from path

       Bitmap bm = ((BitmapDrawable) view.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();

        // converting bytearray to base464

        String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);


        ImaggaClient imaggaApiClient = RetrofitClient.getClient(baseUrl).create(ImaggaClient.class);

        Call<Response> call= imaggaApiClient.uploadImage("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");
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                String result=response.body().getResult().getTags().toString();
                Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"works?",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"notworks!!",Toast.LENGTH_LONG).show();


            }
        });


        String sampleurl="https://i.imgur.com/z6Zd7aG.jpg";
        Call<Response> call2=imaggaApiClient.getTag(sampleurl);
        call2.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response1) {
                String tagList= response1.body().getStatus().getText();
               // Toast.makeText(getApplicationContext(),tagList, Toast.LENGTH_LONG).show();
                 list=response1.body().getResult().getTags();

                final String fakenames[]={"Drainage","Test1","Test2","Test3","test4","test5","test6","test7"};
                final Random rand= new Random();
                randomizer=rand.nextInt(3);
                randomizer++;
                if(1!=randomizer){
                    op1.setText(fakenames[rand.nextInt(7)]);

                }else{
                    op1.setText(list.get(rand.nextInt(9)).getTag().getEn().toString());
                    comparer=op1.getText().toString();


                }
                if(2!=randomizer){
                    op2.setText(fakenames[rand.nextInt(7)]);

                }else{
                    op2.setText(list.get(rand.nextInt(9)).getTag().getEn().toString());
                    comparer=op2.getText().toString();
                }
                if(3!=randomizer){
                    op3.setText(fakenames[rand.nextInt(7)]);

                }else{
                    op3.setText(list.get(rand.nextInt(9)).getTag().getEn().toString());
                    comparer=op3.getText().toString();
                }
                if(4!=randomizer){
                    op4.setText(fakenames[rand.nextInt(7)]);

                }else{
                    op4.setText(list.get(rand.nextInt(9)).getTag().getEn().toString());
                    comparer=op4.getText().toString();
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });









       counter.setText(""+4);
       counter1=4;


        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(op1.getText().toString()==comparer){
                    Toast.makeText(getApplicationContext(),"You Win",Toast.LENGTH_LONG).show();
                }else {
                    if (counter1 == 0) {
                        Toast.makeText(getApplicationContext(), "You lose", Toast.LENGTH_LONG).show();
                        counter.setText(""+0);


                    } else {
                        counter.setText(""+counter1);
                        counter1--;                    }
                }}

        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(op2.getText().toString()==comparer){
                    Toast.makeText(getApplicationContext(),"You Win",Toast.LENGTH_LONG).show();
                }else {
                    if (counter1 == 0) {
                        Toast.makeText(getApplicationContext(), "You lose", Toast.LENGTH_LONG).show();
                        counter.setText(""+0);


                    } else {
                        counter.setText(""+counter1);
                        counter1--;                    }
                }
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(op3.getText().toString()==comparer){
                    Toast.makeText(getApplicationContext(),"You Win",Toast.LENGTH_LONG).show();
                }else {
                    if (counter1 == 0) {
                        Toast.makeText(getApplicationContext(), "You lose", Toast.LENGTH_LONG).show();
                        counter.setText(""+0);


                    } else {
                        counter.setText(""+counter1);
                        counter1--;                    }
                }


            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(op4.getText().toString()==comparer){
                    Toast.makeText(getApplicationContext(),"You Win",Toast.LENGTH_LONG).show();
                }else {
                    if (counter1 == 0) {
                        Toast.makeText(getApplicationContext(), "You lose", Toast.LENGTH_LONG).show();
                        counter.setText(""+0);


                    } else {
                        counter.setText(""+counter1);
                        counter1--;                    }
                }

            }
        });
    }
    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    
}
