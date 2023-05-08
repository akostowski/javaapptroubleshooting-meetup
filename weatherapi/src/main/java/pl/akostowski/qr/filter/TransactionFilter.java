package pl.akostowski.qr.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            logger.error("Thread interrupted", e);
        }
        chain.doFilter(request, response);
    }
}
