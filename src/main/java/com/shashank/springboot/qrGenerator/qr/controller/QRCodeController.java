package com.shashank.springboot.qrGenerator.qr.controller;

import com.google.zxing.WriterException;
import com.shashank.springboot.qrGenerator.qr.util.QRCodeGenerator;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/qr")
public class QRCodeController {

	// http://localhost:8080/api/qr/generate?text=HelloWorld
	@GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> generateQRCode(@RequestParam String text) throws WriterException, IOException {
		byte[] qrImage = QRCodeGenerator.generateQRCodeImage(text, 300, 300);
		return ResponseEntity.ok(qrImage);
	}

	// http://localhost:8080/api/qr/generate-base64?text=HelloWorld
	@GetMapping(value = "/generate-base64", produces = MediaType.TEXT_PLAIN_VALUE)
	public String generateQRCodeBase64(@RequestParam String text) throws WriterException, IOException {
		return QRCodeGenerator.generateBase64QRCode(text, 300, 300);
	}

	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> downloadQRCode(@RequestParam String text) throws WriterException, IOException {
		byte[] qrImage = QRCodeGenerator.generateQRCodeImage(text, 300, 300);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=\"qrcode.png\"").body(qrImage);
	}
}