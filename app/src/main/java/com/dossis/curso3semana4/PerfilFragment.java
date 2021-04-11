package com.dossis.curso3semana4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dossis.curso3semana4.Adapter.MascotaAdapter;
import com.dossis.curso3semana4.POJO.Mascota;

import java.util.ArrayList;

import static com.dossis.curso3semana4.RecyclerviewFragment.mascotasVotacion;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static ArrayList fotosPerfil;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rvPerfil;
    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_perfil, container, false);
        View layout =v.findViewById(R.id.layoutPerritoContainer);
        ImageView imgHuesoBlanco = layout.findViewById(R.id.imgHuesoBlanco);
        imgHuesoBlanco.setVisibility(View.GONE);
        ImageView imgHuesoAmarillo = layout.findViewById(R.id.imgHuestoAmarillo);
        imgHuesoAmarillo.setVisibility(View.GONE);
        TextView tvLikes=layout.findViewById(R.id.tvContadorLikes);
        TextView tvNombre=layout.findViewById(R.id.tvNombre);
         Mascota miMascota= (Mascota) mascotasVotacion.get(0);
         tvNombre.setText(miMascota.getNombre());
        tvLikes.setVisibility(View.GONE);
        ImageView imgFoto = layout.findViewById(R.id.imgFoto);
        imgFoto.setImageResource(miMascota.getIdFoto());

        rvPerfil= v.findViewById(R.id.rvPerfil);
        crearArrayMascotas();
        asociarRecyclerView(v);
        inicializarAdapter();
        return v;
    }
    private void crearArrayMascotas() {
        if (fotosPerfil == null) {
            fotosPerfil = new ArrayList<Mascota>();
            fotosPerfil.add(new Mascota(1, "Rufo", 11, R.drawable.perro1));
            fotosPerfil.add(new Mascota(2, "", 13, R.drawable.perro1));
            fotosPerfil.add(new Mascota(3, "", 7, R.drawable.perro1));
            fotosPerfil.add(new Mascota(4, "", 6, R.drawable.perro1));
            fotosPerfil.add(new Mascota(5, "", 4, R.drawable.perro1));
            fotosPerfil.add(new Mascota(6, "", 8, R.drawable.perro1));
            fotosPerfil.add(new Mascota(7, "", 10, R.drawable.perro1));
            fotosPerfil.add(new Mascota(8, "", 21, R.drawable.perro1));
        }

    }
    private void asociarRecyclerView(View v) {
        rvPerfil= v.findViewById(R.id.rvPerfil);
        GridLayoutManager glm = new GridLayoutManager(v.getContext(),2);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPerfil.setLayoutManager(glm);
    }

    private void inicializarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(fotosPerfil, false,true);
        rvPerfil.setAdapter(adapter);
    }
}