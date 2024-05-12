package com.example.backend002.service.create;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.entity.MemberEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.MemberRepository;
import com.example.backend002.enums.BookStatus;
import com.example.backend002.mapper.MemberMapper;
import com.example.backend002.model.request.create.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberCreateService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final BookRepository bookRepository;

    public void addMember(MemberCreateRequest memberCreateRequest) {
        log.info("Adding a new member: {}", memberCreateRequest.getName());

        // Sadece aktiv veziyyetde olan kitapları alaq
        List<Integer> activeBookIds = bookRepository.findActiveBookIds();

        // MemberCreateRequest içindeki kitaplardan sadece aktiv veziyyetde olanlari filtrle
        List<Integer> requestedBookIds = memberCreateRequest.getBooks().stream()
                .filter(activeBookIds::contains)
                .collect(Collectors.toList());

        // Aktiv kitabların entity'lerini gətir
        List<BookEntity> bookEntities = bookRepository.findByIdIn(requestedBookIds);

        // Eger ki teleb edilen kitablar aktiv deyilse ve ya table'da tapilmirsa xeta ver
        if (requestedBookIds.size() != memberCreateRequest.getBooks().size()) {
            throw new RuntimeException("Inactive or non-existent books selected");

        }

        // İstenen kitabları durumunu deyis: inactive
        bookEntities.forEach(book -> book.setStatus(BookStatus.INACTIVE));

        // Member entity'sini yaradaq
        MemberEntity memberEntity = memberMapper.requestToEntity(memberCreateRequest, bookEntities);

        memberRepository.save(memberEntity);

        log.info("Member added successfully: {}", memberCreateRequest.getName());
    }

}
