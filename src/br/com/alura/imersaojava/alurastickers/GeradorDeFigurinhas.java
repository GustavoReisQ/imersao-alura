package br.com.alura.imersaojava.alurastickers;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // InputStream inputStream =
        // new FileInputStream(new File("entrada/filme-maior.jgp"));
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        int width = imagemOriginal.getWidth();
        int height = imagemOriginal.getHeight();
        int novaAltura = height + 200;

        BufferedImage novaImagem = new BufferedImage(width, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 25);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        graphics.drawString("TOPZERA", 0, novaAltura - 100);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}