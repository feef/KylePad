package com.example.KylePad;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by sharifahmed on 11/19/14.
 */
public class SoundAdapter extends BaseAdapter {

    private Context mContext;
    Dictionary mediaPlayers = new Hashtable();

    public SoundAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        MediaPlayer mediaPlayer = (MediaPlayer) mediaPlayers.get(mThumbIds[position].fileID);
        return mediaPlayer;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new TextView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        final PadView padView;
        final int padID = mThumbIds[position].fileID;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            padView = new PadView(mContext);
            padView.setLayoutParams(new GridView.LayoutParams(minimumCellSide, minimumCellSide));
            padView.setPadding(8, 8, 8, 8);
            padView.setBackgroundColor(Color.parseColor("red"));
        } else {
            padView = (PadView) convertView;
        }

        padView.setText(mThumbIds[position].displayName);

        if(mediaPlayers.get(padID) == null)
        {
            final MediaPlayer mediaPlayer = new MediaPlayer();
            AssetFileDescriptor afd = padView.getContext().getResources().openRawResourceFd(mThumbIds[position].fileID);
            try {
                mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                afd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    if (mediaPlayer == padView.mediaPlayer)
                        padView.setBackgroundColor(Color.parseColor("blue"));
                }
            });
            padView.mediaPlayer = mediaPlayer;
            mediaPlayers.put(padID, padView.mediaPlayer);
            mediaPlayer.prepareAsync();
        }
        else {
            padView.mediaPlayer = (MediaPlayer) mediaPlayers.get(padID);
        }

        return padView;
    }

    // references to our images
    public Sound[] mThumbIds = {
            new Sound(R.raw.andiwishyoujoy1,"And I wish you joy"), new Sound(R.raw.aww1, "aww 1"),
            new Sound(R.raw.aww2, "aww 2"), new Sound(R.raw.aww3, "aww 3"),
            new Sound(R.raw.aww4, "aww 4"), new Sound(R.raw.aww5, "aww 5"),
            new Sound(R.raw.aww6, "aww 6"), new Sound(R.raw.butthole1, "butthole"),
            new Sound(R.raw.candyapples1, "candy apples"), new Sound(R.raw.cry1, "cry 1"),
            new Sound(R.raw.cry2, "cry 2"), new Sound(R.raw.cry3, "cry 3"),
            new Sound(R.raw.dontyouknowjesus1, "don't you know jesus"), new Sound(R.raw.gimmeagoddamncigaretteyasweetie1, "gimme a goddamn cigarette ya sweetie"),
            new Sound(R.raw.ginger1, "ginger"), new Sound(R.raw.gingersnap1, "gingersnap"),
            new Sound(R.raw.guesswhat1, "guesswhat1"), new Sound(R.raw.ididntknowthatyoulikedchocolate1, "i didn't know that you liked chocolate"),
            new Sound(R.raw.igotapopsicleinmymouth1, "i got a popsicle in my mouth"), new Sound(R.raw.imgonnalickitlikea1, "i'm gonna lick it like a"),
            new Sound(R.raw.irememberwhentheyfuckinginventedchocolate1, "i remember when they invented chocolate"), new Sound(R.raw.jesus1, "jesus 1"),
            new Sound(R.raw.jesus2, "jesus 2"), new Sound(R.raw.jesusitdoesntfit1, "jesus it doesn't fit"),
            new Sound(R.raw.likeacigaretteinmyasshole1, "like a cigarette in my asshole"), new Sound(R.raw.michaeljackson1, "michael jackson"),
            new Sound(R.raw.mmm1, "mmm 1"), new Sound(R.raw.mmm2, "mmm 2"),
            new Sound(R.raw.mmm3, "mmm 3"), new Sound(R.raw.mmm4, "mmm 4"),
            new Sound(R.raw.moan1, "moan 1"), new Sound(R.raw.moan2, "moan 2"),
            new Sound(R.raw.moan3, "moan 3"), new Sound(R.raw.moan4, "moan 4"),
            new Sound(R.raw.moan5, "moan 5"), new Sound(R.raw.moan6, "moan 6"),
            new Sound(R.raw.moan7, "moan 7"), new Sound(R.raw.moan8, "moan 8"),
            new Sound(R.raw.moan9, "moan 9"), new Sound(R.raw.moan10, "moan 10"),
            new Sound(R.raw.mommymadememashmymandms1, "mommy made me mash my m and ms"), new Sound(R.raw.mybutthole1, "my butthole"),
            new Sound(R.raw.nono1, "no no"), new Sound(R.raw.ohbaby1, "oh baby"),
            new Sound(R.raw.ohcandycigarettes1, "oh candy cigarettes"), new Sound(R.raw.ohgottabigdick1, "oh gotta big dick"),
            new Sound(R.raw.ohifuckinghatedit1, "oh i fucking hated it"), new Sound(R.raw.ohittasted1, "oh it tasted"),
            new Sound(R.raw.ohjesus1, "oh jesus 1"), new Sound(R.raw.ohjesus2, "oh jesus 2"),
            new Sound(R.raw.ohlittleboy1, "oh little boy"), new Sound(R.raw.ohmygodyeah1, "oh my god yeah"),
            new Sound(R.raw.ohyeah1, "oh yeah 1"), new Sound(R.raw.ohyeah2, "oh yeah 2"),
            new Sound(R.raw.ohyeah3, "oh yeah 3"), new Sound(R.raw.riff1, "riff 1"),
            new Sound(R.raw.riff2, "riff 2"), new Sound(R.raw.scream1, "scream 1"),
            new Sound(R.raw.scream2, "scream 2"), new Sound(R.raw.scream3, "scream 3"),
            new Sound(R.raw.shortscreams1, "short screams"), new Sound(R.raw.slurp1, "slurp 1"),
            new Sound(R.raw.slurp2, "slurp 2"), new Sound(R.raw.smokinlikeavag1, "smoking like a vag"),
            new Sound(R.raw.squeal1, "squeal 1"), new Sound(R.raw.squeal2, "squeal 2"),
            new Sound(R.raw.suckindick1, "suckin dick 1"), new Sound(R.raw.suckindick2, "suckin dick 2"),
            new Sound(R.raw.suckindick3, "suckin dick 3"), new Sound(R.raw.suckindick4, "suckin dick 4"),
            new Sound(R.raw.sweetie1, "sweetie"), new Sound(R.raw.tard1, "tard 1"),
            new Sound(R.raw.tard2, "tard 2"), new Sound(R.raw.trainwhistle1, "trainwhistle"),
            new Sound(R.raw.up1, "up 1"), new Sound(R.raw.up2, "up 2"),
            new Sound(R.raw.up3, "up 3"), new Sound(R.raw.up4, "up 4"),
            new Sound(R.raw.up3, "up 5"), new Sound(R.raw.up4, "up 6"),
            new Sound(R.raw.yeahyouknowexactlywhatthatfeelslike1, "yeah you know exactly what that feels like"),
            new Sound(R.raw.yoda1, "yoda 1"), new Sound(R.raw.yoda2, "yoda 2"),
            new Sound(R.raw.yoda3, "yoda 3"), new Sound(R.raw.youginger1, "you ginger"),
            new Sound(R.raw.yougotabig1, "you got a big"), new Sound(R.raw.yougotabigdick1, "you got a big dick"),
            new Sound(R.raw.yougotabigol1, "you got a big ol"), new Sound(R.raw.yougotabigoldick1, "you got a big ol dick")
    };

    public int minimumCellSide = 100;
}
