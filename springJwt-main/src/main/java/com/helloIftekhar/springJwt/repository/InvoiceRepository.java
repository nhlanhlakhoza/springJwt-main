package com.helloIftekhar.springJwt.repository;


import com.helloIftekhar.springJwt.model.Invoice;
import com.helloIftekhar.springJwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    long countByUser(User user);


    List<Invoice> findByUserEmail(String userEmail);

    List<Invoice> findTop5ByUserOrderByDateDesc(User user);

    Invoice findByInvoiceNoAndUser(int invoiceNo, User user);

    Boolean existsByInvoiceNo(int invoiceNo);

    @Query("SELECT SUM(i.totalAmount) FROM Invoice i WHERE i.user.email = :userEmail AND i.paymentStatus = 'unpaid'")
    Double getTotalUnpaidAmount(@Param("userEmail") String userEmail);



}
