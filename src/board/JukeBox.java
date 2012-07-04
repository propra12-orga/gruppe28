package board;

//import java.net.URL;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class JukeBox
{
	static String sound;
	public static void playSoundeffect(String effect) throws LineUnavailableException, UnsupportedAudioFileException, IOException
	{
		if(effect=="door"){
			sound="./res/Sounds/door.wav";
		}
		else if(effect=="scream"){
			sound="./res/Sounds/scream.wav";
		}
		else if(effect=="boom"){
			sound="./res/Sounds/boom.wav";
		}
		else if(effect=="gatewalk"){
			sound="./res/Sounds/gatewalk.wav";
		}
		File f = new File(sound);
			AudioInputStream ais = AudioSystem.getAudioInputStream(f);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat(), ( (int)ais.getFrameLength() * format.getFrameSize()));
			Clip cl = (Clip) AudioSystem.getLine(info);
				cl = (Clip) AudioSystem.getLine(info);
				cl.open(ais);
				cl.start();
		
	}
	public static void playGamemusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException
	{
		File f = new File("./res/Sounds/duel.wav");
		
			AudioInputStream ais = AudioSystem.getAudioInputStream(f);
			AudioFormat format = ais.getFormat();
			if((format.getEncoding() == AudioFormat.Encoding.ULAW)||(format.getEncoding() == AudioFormat.Encoding.ALAW))
			{
				AudioFormat tmp = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
													format.getSampleRate(), 
													format.getSampleSizeInBits()*2, 
													format.getChannels(), 
													format.getFrameSize()*2,
													format.getFrameRate(),
													true);
				ais = AudioSystem.getAudioInputStream(tmp, ais);
				format=tmp;
			}
			DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat(), ( (int)ais.getFrameLength() * format.getFrameSize()));
			Clip cl = (Clip) AudioSystem.getLine(info);
				cl = (Clip) AudioSystem.getLine(info);
				cl.open(ais);
				cl.start();
		
	}
	
}