package com.br.blogging.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Arrays;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostModel updateDTO(Long idPost, PostDTO postDTO){
        Optional<PostModel> existingPost = postRepository.findById(idPost);

        if (existingPost.isPresent()){
            PostModel post = existingPost.get();

            if (postDTO != null){
                post.setIdPost(postDTO.getIdPost());
                post.setTitle(postDTO.getTitle());
                post.setContent(postDTO.getContent());
                post.setImage(postDTO.getImage());
            } else {
                return null;
            }
            return postRepository.save(post);
        }
        return null;
    }
    private List<String> offensiveWords = Arrays.asList("bobao","feio");
    //private List<String> offensiveWords = Arrays.asList("aidético","aidética","aidética","aleijado","aleijada","aleijada","analfabeto","analfabeto","analfabeta","analfabeta","anus","anão","anãanã","arrombado","apenado","apenada","baba-ovo","babaca","babaovo","bacura","bagos","baianada","baitolabaitola","barbeiro","barraco","beata","bebum","besta","bicha","bisca","bixa","boazuda","boceta","boco","boiola","bokete","bolagato","bolcat","boquete","bosseta","bosta","bostana","boçal","branquelo","brecha","brexa","brioco","bronha","bucabuceta","bunduda","burra","burro","","bárbaro","bêbado","bêbedo","caceta","cacete","cachorra","cachorro","cadela","caga","cagado","cagao","cagão","cagona","caipira","canalha","canceroso","caralho","casseta","cassete","ceguinho","checheca","chereca","chibumba","chibumbo","chifruda","chifrudo","chochota","chota","chupada","chupado","ciganos","clitoris","clitóris","cocaina","cocaína","coco","cocô","comunista","corna","cornagem","cornisse","corno","cornuda","cornudo","cornão","corrupta","corrupto","coxo","cretina","cretino","criolo","crioulo","cruz-credo","cu","cú","culhao","culhão","curalho","cuzao","cuzão","cuzuda","cuzudo","debil","débil","debiloide","debilóide","deficiente","defunto","demonio","demônio","denegrir","denigrir","detento","difunto","doida","doido","egua","égua","elemento","encostado","esclerosado","escrota","escroto","esporrada","esporrado","esporro","estupida","estúpida","estupidez","estupido","estúpido","facista","fanatico","fanático","fascista","fedida","fedido","fedor","fedorenta","feia","feio","feiosa","feioso","feioza","feiozo","felacao","felação","fenda","foda","fodao","fodão","fode","fodi","fodida","fodido","fornica","fornição","fudendo","fudeção","fudida","fudido","furada","furado","furnica","furnicar","furo","furona","furão","gai","gaiata","gaiato","gay","gilete","goianada","gonorrea","gonorreia","gonorréia","gosmenta","gosmento","grelinho","grelo","gringo","homo-sexual","homosexual","homosexualismo","homossexual","homossexualismo","idiota","idiotice","imbecil","inculto","iscrota","iscroto","","japa","judiar","ladra","ladrao","ladroeira","ladrona","ladrão","lalau","lazarento","leprosa","leproso","lesbica","lésbica","louco","macaca","macaco","machona","macumbeiro","malandro","maluco","maneta","marginal","masturba","meleca","meliante","merda","mija","mijada","mijado","mijo","minorias","mocrea","mocreia","mocréia","moleca","moleque","mondronga","mondrongo","mongol","mongoloide","mongolóide","mulata","mulato","naba","nadega","nádega","nazista","negro","nhaca","nojeira","nojenta","nojento","nojo","olhota","otaria","otario","otária","otário","paca","palhaco","palhaço","paspalha","paspalhao","paspalho","pau","peia","peido","pemba","pentelha","pentelho","perereca","perneta","peru","peão","pica","picao","picão","pilantra","pinel","pinto","pintudo","pintão","piranha","piroca","piroco","piru","pivete","porra","prega","preso","prequito","priquito","prostibulo","prostituta","prostituto","punheta","punhetao","punhetão","pus","pustula","puta","puto","puxa-saco","puxasaco","penis","pênis","rabao","rabão","rabo","rabuda","rabudao","rabudão","rabudo","rabudona","racha","rachada","rachadao","rachadinha","rachadinho","rachado","ramela","remela","retardada","retardado","ridícula","roceiro","rola","rolinha","rosca","sacana","safada","safado","sapatao","sapatão","sifilis","sífilis","siririca","tarada","tarado","testuda","tesuda","tesudo","tezao","tezuda","tezudo","traveco","trocha","trolha","troucha","trouxa","troxa","tuberculoso","tupiniquim","turco","vaca","vadia","vagal","vagabunda","vagabundo","vagina","veada","veadao","veado","viada","viadagem","viadao","viadão","viado","viadão","víado","xana","xaninha","xavasca","xerereca","xexeca","xibiu","xibumba","xiíta","xochota","xota","xoxota");

    public boolean isPostContentValid(String postContent){
        for(String word : offensiveWords){
            if (postContent.toLowerCase().contains(word.toLowerCase())){
                return false;
            }
        }
        return true;
    }
}
