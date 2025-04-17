package com.crud.card.service;

import com.crud.card.model.Alumno;
import com.crud.card.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.List;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    private IAlumnoRepository iAlumnoRepository;

    @Override
    public void insertarAlumnos(int cantidad) {
        try {
            for (int i = 0; i < cantidad; i++) {
                Alumno alumno = new Alumno();
                alumno.setCarrera("1490");
                alumno.setAnio("21");
                alumno.setCorrelativo(generarCorrelativo(i));
                alumno.setPnombre("Nombre" + i);
                alumno.setSnombre("Segundo" + i);
                alumno.setPapellido("ApellidoP" + i);
                alumno.setSapellido("ApellidoS" + i);
                alumno.setTelefono("12345678");
                alumno.setEmail("correo" + i + "@example.com");
                alumno.setInstitucion("Universidad Ejemplo");
                alumno.setTipoParticipante((short) 1); // tipo genérico
                alumno.setQrcode(null);
                alumno.setBoleta(null);

                iAlumnoRepository.save(alumno);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al insertar alumnos", ex);
        }
    }

    @Override
    public Alumno findByCorrelativo(String cCorrelativo) {
        return null;
    }

    private String generarCorrelativo(int i) {
        return String.format("%06d", i + 1);
    }

    ///codigo qr


    @Override
    public List<Alumno> findAll() {
        List<Alumno> list;
        try {
            list = iAlumnoRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

/*    @Override
    public int save(Alumno alumno) {
        int row;
        try {
            row = iAlumnoRepository.save(alumno);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }
*/

    @Override
    public int save(Alumno alumno) {
        try {
            //valida si subio boleta
            /*if (alumno.getBoleta() == null || alumno.getBoleta().length == 0) {
                throw new RuntimeException("Debe subir la boleta para generar el código QR.");
            }
            //valida tipo de archivo jpg,png o pdf
            if (!pdfoimg(alumno.getBoleta())) {
                throw new RuntimeException("La boleta debe ser un archivo PDF o una imagen JPG/PNG.");
            }*/
            // genera el qr
            byte[] qr = QRCodeGenerator.generateQRCodeImage("simposio: " + alumno.getCorrelativo());
            alumno.setQrcode(qr);


            return iAlumnoRepository.save(alumno);
        } catch (WriterException | IOException ex) {
            throw new RuntimeException("Error al generar el codigo qr ", ex);
        }
    }

    @Override
    public int update(Alumno alumno) {
        int row;
        try {
            row = iAlumnoRepository.update(alumno);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int deletedById(String cCorrelativo) {
        int row;
        try {
            row = iAlumnoRepository.deletedById(cCorrelativo);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    private boolean pdfoimg(byte[] fileData) {
        if (fileData.length < 4) return false;

        String header = new String(fileData, 0, 4);
        if (header.equals("%PDF")) return true;

        if ((fileData[0] & 0xFF) == 0xFF && (fileData[1] & 0xFF) == 0xD8) return true;

        if ((fileData[0] & 0xFF) == 0x89 && (fileData[1] & 0xFF) == 0x50 &&
                (fileData[2] & 0xFF) == 0x4E && (fileData[3] & 0xFF) == 0x47) return true;

        return false;
    }

    public byte[] getQRByCorrelativo(String cCorrelativo) {
        Alumno alumno = iAlumnoRepository.findByCorrelativo(cCorrelativo);
        if (alumno == null || alumno.getQrcode() == null) {
            throw new RuntimeException("QR no encontrado para el alumno con correlativo: " + cCorrelativo);
        }
        return alumno.getQrcode();
    }

}