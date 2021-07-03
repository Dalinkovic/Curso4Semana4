package com.dossis.curso4semana4.activitys;

import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dossis.curso4semana4.R;
import com.dossis.curso4semana4.adapter.FirebaseAdapter;
import com.dossis.curso4semana4.interfaces.IFirebaseEndpoint;
import com.dossis.curso4semana4.pojo.UsuarioResponse;
import com.dossis.curso4semana4.restApi.Keys;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecibirNotificacionesActivity extends BaseActivity {
private final String TAG="RecibirNotificacionesActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir_notificaciones);

        if (toolbar == null) {
            setActionBar(this, true);
        }

    }

    public void btnRecibirNotificacionesClick(View view) {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();
                        enviarTokenRegistro(token);
                        // Log and toast
                        //String msg = getString(R.string.msg_token_fmt, token);
                        //  Log.d(TAG, msg);
                        // Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @SuppressLint("LongLogTag")
    private void enviarTokenRegistro(String token) {
        Log.d(TAG, "enviarTokenRegistro token:" + token);
        FirebaseAdapter firebaseAdapter = new FirebaseAdapter();
        IFirebaseEndpoint firebaseDB = firebaseAdapter.establecerConexionRestAPI();
        //String idIG= Keys.ACTIVE_USER_NAME;
        String idIG= Keys.USER_ID;

        Call<UsuarioResponse> usuarioResponseCall = firebaseDB.registrarTokenID(token, idIG);
        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_FIREBASE", usuarioResponse.getId());
                Log.d("TOKEN_FIREBASE", usuarioResponse.getTokenFCM());
                Log.d("ID_INSTAGRAM", usuarioResponse.getIdIG());
                Toast.makeText(RecibirNotificacionesActivity.this, "ID_FIREBASE: " +usuarioResponse.getId() + "\nTOKEN_FIREBASE: " + usuarioResponse.getTokenFCM() + "\nID_INSTAGRAM: " +usuarioResponse.getIdIG(), Toast.LENGTH_SHORT).show();
            }



            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Log.e(TAG, "Error usuarioResponse", t);
            }
        });

    }
}