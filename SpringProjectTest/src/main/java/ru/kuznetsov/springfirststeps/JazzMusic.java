package ru.kuznetsov.springfirststeps;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JazzMusic implements Music{
    @Override
    public String getSong() {

        return "Garota de Ipanema";
    }
}
