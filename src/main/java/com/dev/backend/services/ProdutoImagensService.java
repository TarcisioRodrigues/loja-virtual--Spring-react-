package com.dev.backend.services;

import com.dev.backend.entity.Produto;
import com.dev.backend.entity.ProdutosImagens;

import com.dev.backend.repository.ProdutoImagensRepository;
import com.dev.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
@Service
public class ProdutoImagensService {
    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutosImagens> list(){
        return produtoImagensRepository.findAll();
    }
    public ProdutosImagens create(Long idProduto, MultipartFile file){
        Produto produto=produtoRepository.findById(idProduto).get();
        ProdutosImagens produtosImg= new ProdutosImagens();
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem=String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("C:\\Users\\Tarcisio Rodrigues\\Imagens" + nomeImagem + "_image.jpg");
                System.out.println(caminho+"Aqui");
                Files.write(caminho, bytes);

                produtosImg.setNome(nomeImagem);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        produtosImg.setProduto(produto);
        produtosImg.setCreated_at(new Date());
        ProdutosImagens produtosImagensNovo= produtoImagensRepository.saveAndFlush(produtosImg);
        return produtosImagensNovo;
    }

    public ProdutosImagens update(ProdutosImagens produtoImagens){
        produtoImagens.setUpdated_at(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }


    public void delete(Long id){
        ProdutosImagens produtoImagens= produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(produtoImagens);
    }
}
