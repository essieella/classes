import java.awt.image.ImageObserver;
import java.awt.Image;

public class artmuseum extends FlexiblePictureExplorer implements ImageObserver {
	private boolean map;
	private boolean cochineal = false; 
	private boolean ai = false;
	private boolean bauhaus = false;
	private boolean katagami = false; 
	private boolean helpdesk = false;
	int katagami_counter = 1;
	int bauhaus_counter = 1;
	int cochineal_counter = 1;
	int ai_counter = 1;
	private boolean cochineal_was_clicked = false;
	private boolean ai_was_clicked = false;
	private boolean bauhaus_was_clicked = false;
	private boolean katagami_was_clicked = false;
	private boolean q1 = false;
	private boolean q2 = false;
	private boolean q3 = false;
	private int quiz = 0;
	int num = 0;
	public artmuseum(DigitalPicture p) {
		super(new Picture(600, 600));
		map(p);
	}

	public void map(DigitalPicture p) {
		setImage(p);
		setTitle("Cooper Hewitt");
		map = true;
	}

	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		return false;
	}

	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
		if (map & pix.getX() > 390 && pix.getY() > 350 && pix.getX() < 580 && pix.getY() < 570){
			// System.out.println("katagami");
			katagami_was_clicked = true;
			DigitalPicture a = new Picture("labels//katagami_info_wall.png");
			setImage(a);
			map = false;
			katagami = true;
		} 
		if (map & pix.getX() > 20 && pix.getY() > 20 && pix.getX() < 210 && pix.getY() < 240) {
			// System.out.println("cochineal");
			cochineal_was_clicked = true;
			DigitalPicture b = new Picture("labels//cochineal_info_wall.png");
			setImage(b);
			map = false;
			cochineal = true;
		}
		if (map & pix.getX() > 390 && pix.getY() > 20 && pix.getX() < 580 && pix.getY() < 240){
			// System.out.println("ai");
			ai_was_clicked = true;
			DigitalPicture a = new Picture("labels//ai_info_wall.png");
			setImage(a);
			map = false;
			ai = true;
		} 
		if (map & pix.getX() > 20 && pix.getY() > 350 && pix.getX() < 210 && pix.getY() < 580) {
			// System.out.println("bauhaus");
			bauhaus_was_clicked = true;
			DigitalPicture b = new Picture("labels//bauhaus_info_wall.png");
			setImage(b);
			map = false;
			bauhaus = true;
		} if (katagami & pix.getX() > 501 & pix.getX() < 559 & pix.getY() > 531 & pix.getY() < 553) {
			// System.out.println("arrow pressed: " + katagami_counter);
			DigitalPicture a = new Picture("labels//katagami_slide1.png");
			DigitalPicture b = new Picture("labels//katagami_slide2.png");
			DigitalPicture c = new Picture("labels//katagami_slide3.png");
			DigitalPicture d = new Picture("labels//map.png");
			if (katagami_counter == 1) {
				setImage(a);
			} else if (katagami_counter == 2) {
				setImage(b);
			} else if (katagami_counter == 3) {
				setImage(c);
			} else {
				map = true;
				katagami = false;
				setImage(d);
				katagami_counter = 0;
				quiz();
			}
			katagami_counter++;
		} if (cochineal & pix.getX() > 501 & pix.getX() < 559 & pix.getY() > 531 & pix.getY() < 553) {
			DigitalPicture a = new Picture("labels//cochineal_slide1.png");
			DigitalPicture b = new Picture("labels//cochineal_slide2.png");
			DigitalPicture c = new Picture("labels//cochineal_slide3.png");
			DigitalPicture d = new Picture("labels//map.png");
			if (cochineal_counter == 1) {
				setImage(a);
			} else if (cochineal_counter == 2) {
				setImage(b);
			} else if (cochineal_counter == 3) {
				setImage(c);
			} else {
				map = true;
				cochineal = false;
				setImage(d);
				cochineal_counter = 0;
				quiz();
			}
			cochineal_counter++;
		} if (bauhaus & pix.getX() > 501 & pix.getX() < 559 & pix.getY() > 531 & pix.getY() < 553) {
			DigitalPicture a = new Picture("labels//bauhaus_slide1.png");
			DigitalPicture b = new Picture("labels//bauhaus_slide2.png");
			DigitalPicture c = new Picture("labels//bauhaus_slide3.png");
			DigitalPicture d = new Picture("labels//map.png");
			if (bauhaus_counter == 1) {
				setImage(a);
			} else if (bauhaus_counter == 2) {
				setImage(b);
			} else if (bauhaus_counter == 3) {
				setImage(c);
			} else {
				map = true;
				bauhaus = false;
				setImage(d);
				bauhaus_counter = 0;
				quiz();
			}
			bauhaus_counter++;
		}
		if (ai & pix.getX() > 501 & pix.getX() < 559 & pix.getY() > 531 & pix.getY() < 553) {
			DigitalPicture a = new Picture("labels//ai_slide1.png");
			DigitalPicture b = new Picture("labels//ai_slide2.png");
			DigitalPicture c = new Picture("labels//ai_slide3.png");
			DigitalPicture d = new Picture("labels//map.png");
			if (ai_counter == 1) {
				setImage(a);
			} else if (ai_counter == 2) {
				setImage(b);
			} else if (ai_counter == 3) {
				setImage(c);
			} else {
				map = true;
				ai = false;
				setImage(d);
				ai_counter = 0;
				quiz();
			}
			ai_counter++;
			// System.out.println(ai_counter);
		} if (map & pix.getX() > 229 & pix.getX() < 375 & pix.getY() > 264 & pix.getY() < 332) {
			map = false;
			helpdesk = true;
			DigitalPicture a = new Picture("labels//helpdesk.png");
			setImage(a);
		} if (helpdesk & pix.getX() > 501 & pix.getX() < 559 & pix.getY() > 531 & pix.getY() < 553) {
			map = true;
			helpdesk = false;
			DigitalPicture a = new Picture("labels//map.png");
			setImage(a);
		} if ((ai || bauhaus || cochineal || katagami) && pix.getX() > 228 && pix.getX() < 375 && pix.getY() > 494 && pix.getY() < 528) {
			if (ai) {
				// System.out.println("info: " + ai_counter);
				String[] message = {"an interactive installation created by Zachary Lieberman.\n Its medium is computer, camera, monitor, electronic components, and software (openframeworks (c++), python, keras).", 
				        "In the future, people will control computers with their faces, eyes, and even their minds. \n Expression Mirror, created by Zachary Lieberman, invites you to use your face to interact with the computer, camera, and screen. \n Custom software seeks matches with the facial expressions of other visions, combining faces to generate unique social portraits. \n Dynamic white lines create an abstract, graphic interpretation of emotional states.",
						"a video designed by Jessica Helfand. \n Its medium is video.", 
						"Judging a person's character from their facial features has a long history, linked to racial stereotypes and criminal profiling. \n For centures, artists and scientists have measured and codified facial features. \n These practices often serve ideologies of white racial superiority and the belief that moral character is written on the face and skull.", 
						"an interactive installation designed by Karen Palmer. \n Its medium is video monitors, computer, eye-tracking hardware and software, additional software.", 
						"Exploring the intersection of A.I., emotion detection, eye tracking, and bias, this immersive storytelling experience reveals how your gaze and emotions influence your perception of reality. \n Perception IO (input output) is a prototype and ongoing work-in-progress. \n This reality simulator invites you to evaluate your perceptions, become aware of your subconscious behavior, and reprogram it.\n" + 
						"You will take the position of a police officer watching a training video of a volatile situation. \n How you respond will have consequences for the characters. \n The system will track your eye movements and facial expressions. \n Analysis of your gaze and your expressions will be revealed, and you will be able to examine your own implicit biases. \n How comfortable are you with the idea that your perceptions of reality have real-life consequences? \n Would you bet your life on it?"
						};
				if (ai_counter == 2) {
					makePopUp(message[0]);
					// makePopUp(message[1]);
				} else if (ai_counter == 3) {
					makePopUp(message[2]);
					// makePopUp(message[3]);
				} else if (ai_counter == 4) {
					makePopUp(message[4]);
					// makePopUp(message[5]);
				}
			} if (bauhaus) {
				String[] message = {"This is a Poster designed by Herbert Bayer. We acquired it in 2009. Its medium is offset lithograph on white wove paper.", 
						"This is a Book cover written by A. A. Brill and designed by Herbert Bayer and published by Alfred A. Knopf and Vintage Books. \r\n It is dated 1955 and we acquired it in 2016. Its medium is offset lithograph on thick cream paper.", 
						"This is a Print. It was designed by Herbert Bayer and made for (as the client) Noreen." + " It is dated ca. 1956 and we acquired it in 2016. \r\n Its medium is offset lithograph on glossy white paper."};
				if (bauhaus_counter == 2) {
					makePopUp(message[0]);
				} else if (bauhaus_counter == 3) {
					makePopUp(message[1]);
				} else if (bauhaus_counter == 4) {
					makePopUp(message[2]);
				}
			} if (cochineal) {
				String[] message = {"This is a Textile. It was created by James Bassler. It is dated 2009 and we acquired it in 2018. Its medium is hemp, cochineal-dyed alpaca, natural brown cotton, natural alpaca.", 
						"This is a Console. It was designed by Gloria Cortina. Its medium is cochineal lacquer, wood, bronze, black obsidian.", 
						"This is a Vessel. It was manufactured by Emerging Objects. It is dated 2019. Its medium is 3-d printed nylon, cochineal dye."};
				if (cochineal_counter == 2) {
					makePopUp(message[0]);
				} else if (cochineal_counter == 3) {
					makePopUp(message[1]);
				} else if (cochineal_counter == 4) {
					makePopUp(message[2]);
				}
			} if (katagami) {}
			    String[] message = {
			    		"This is a Stencil. We acquired it in 1946. Its medium is mulberry paper (kozo washi) treated with fermented persimmon juice (kakishibu), silk threads (itoire).",
			    		"This is a Child's kimono. It is dated late 18th century and we acquired it in 1956. Its medium is cotton and its technique is stencil resist (katazome) on plain weave.",
			    		"This is a Stencil. We acquired it in 1976. Its medium is mulberry paper (kozo washi) treated with fermented persimmon tannin (kakishibu), and silk threads (itoire)."
			    };
			    if (katagami_counter == 2) {
					makePopUp(message[0]);
				} else if (katagami_counter == 3) {
					makePopUp(message[1]);
				} else if (katagami_counter == 4) {
					makePopUp(message[2]);
				}
			} 
		if (q1 && !map) {
			System.out.println("q1");
			if (pix.getX() > 36 & pix.getX() < 376 & pix.getY() > 381 && pix.getY() < 407) {
				num = num + 1;
			} else if (pix.getX() > 0 && pix.getX() < 600 && pix.getY() > 0 && pix.getY() < 600) {
				num = num + 0;
			} 
			DigitalPicture q2_pic = new Picture("labels//q2.png");
			q2 = true;
			q1 = false;
			setImage(q2_pic);
		} else if (q2 & !map) {
			System.out.println("q2");
			if (pix.getX() > 36 & pix.getX() < 376 & pix.getY() > 381 && pix.getY() < 407) {
				num = num + 1;
			} else if (pix.getX() > 0 && pix.getX() < 600 && pix.getY() > 0 && pix.getY() < 600) {
				num = num + 0;
			}
			DigitalPicture q3_pic = new Picture("labels//q3.png");
			q3 = true;
			q2 = false;
			setImage(q3_pic);
		} else if (q3 & !map) {
			System.out.println("q3");
			if (pix.getX() > 36 & pix.getX() < 376 & pix.getY() > 381 && pix.getY() < 407) {
				num = num + 1;
			} else if (pix.getX() > 0 && pix.getX() < 600 && pix.getY() > 0 && pix.getY() < 600) {
				num = num + 0;
			}
			// DigitalPicture final_pic = new Picture("labels//final.png");
			q3 = false;
			map = true;
			quiz++;
			makePopUp("Number correct: "+ num);
			// setImage(final_pic);
			// System.out.println("num correct: " + num);
			// Graphics2D graphics = disp.createGraphics();
			// graphics.setColor(Color.red);
			// graphics.setFont(new Font("Times", Font.BOLD, 26));
			// String message = "number correct: " + num + "";
			// graphics.drawString(message, 60, 650);
		}
	}

	public void quiz() {
		if (ai_was_clicked && bauhaus_was_clicked && cochineal_was_clicked && katagami_was_clicked && quiz == 0) {
			// makePopUp("You have viewed all of the virtual collection. It's quiz time!");
			DigitalPicture p = new Picture("labels//q1.png");
			setImage(p);
			q1 = true;
		}
	}
	
	public static void main(String[] args) {
		Picture p = new Picture("labels//map.png");
		artmuseum a = new artmuseum(p);
	}

}
