package adaptadores;

public class Adaptadores {

    public static void main(String[] args) {
        MediaPlayer player = new MP3();
        player.play("file.mp3");
        player = new FormatAdapter(new MP4());
        player.play("file.mp4");
        player = new FormatAdapter(new VLC());
        player.play("file.avi");
        player = new FormatAdapter(new DIVX());
         player.play("file.divx");
        
    }

    private static class FormatAdapter implements MediaPlayer {

        private Object media;

        public FormatAdapter(MediaPackage m) {
            media = m;
        }
        public FormatAdapter(MediaDivX m) {
            media = m;
        }
        
        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");
            if (media instanceof VLC){
            VLC adaptado = (VLC)media;
                adaptado.playFile(filename);
            
            }
            
            if (media instanceof DIVX){
            DIVX adaptado = (DIVX)media;
                adaptado.playFilm(filename);
            
            }
            if (media instanceof MP4){
             MP4 x = (MP4)media;
                x.playFile(filename);
            
            }
            
        }
    }
}
