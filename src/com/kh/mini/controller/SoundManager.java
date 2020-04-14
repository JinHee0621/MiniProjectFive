package com.kh.mini.controller;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;

public class SoundManager {
	
	private static SoundManager soundinst;
	public static File bgm;
	public static File sfx;
	static Clip bgmClip;
	static Clip[] sfxClip = new Clip[6];
	static int sfxNum = 4;
	
	public static SoundManager Instance() {
		
		if(soundinst != null) {
			return soundinst;	
		} else {
			soundinst = new SoundManager();
			return soundinst;
		}
	}
	
	public static void bgmPlay() {
		AudioInputStream stream;
		AudioFormat format;
		Info info;
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			bgmClip = (Clip) AudioSystem.getLine(info);
			bgmClip.open(stream);
			bgmClip.start();
			} catch (Exception e) {
			System.out.println("BGM err : " + e);
		}
	}
	

	public void bgmSelect(String soundName) {
		bgm = new File("sounds\\BGM\\"+soundName+".wav");
		bgmPlay();
	}
	
	public void bgmStop() {
		bgmClip.close();
		bgmClip.stop();
	}
	
	public static void sfxPlay() {
		AudioInputStream stream;
		AudioFormat format;
		Info info;
		
		try {
			if(sfxNum < 4) {
				sfxNum %= 4;
			} else {
				sfxNum = 0;
			}
			stream = AudioSystem.getAudioInputStream(sfx);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			sfxClip[sfxNum] = (Clip) AudioSystem.getLine(info);
			sfxClip[sfxNum].open(stream);
			sfxClip[sfxNum].start();

		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}
	
	public void sfxSelect(String soundName) {
		sfx = new File("sounds\\SFX\\"+soundName+".wav");
		sfxPlay();
	}
}

