package com.tinqin.accountingproject.persistence.repository;


import com.tinqin.accountingproject.persistence.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, UUID>, PagingAndSortingRepository<Invoice,UUID>
{
    Optional<Invoice> findByInvoiceId(String invoiceId);
    List<Invoice> findAllByDateOfCreationBetween(Timestamp start, Timestamp end);
    List<Invoice> findAllByDateOfPayment(Timestamp date);


}
