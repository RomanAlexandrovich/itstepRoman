package org.rest.ws.core;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.rest.util.XMLCurrencyParser;
import org.rest.ws.model.Currency;

@Path("rates")
public class CurrencyService {
	
		
	private List<String> codes = Arrays.asList("840", "643", "978");
    
    @GET
    @Path("/all")
    public Response getMainRurrencyValues() {
        StringBuilder sb = new StringBuilder(64);
        for (String code : codes) {
            sb
            .append(code).append(":").append(calc(XMLCurrencyParser.getCurrency(code)))
            .append("<br>");
        }
        return Response.status(200).entity(sb.toString()).build();
    }
		/*
		 * -<Currency Id="170">
		    <NumCode>036</NumCode>
		    <CharCode>AUD</CharCode>
		    <Scale>1</Scale>
		    <Name>������������� ������</Name>
		    <Rate>1.4514</Rate>
			</Currency>
		 */
		@GET
		@Path("/{code}")
		public Response getCurrency(@PathParam("code") String code) {

			String nbrbRateTxt=XMLCurrencyParser.getCurrency(code);
			double nbrbRateNum=Double.parseDouble(nbrbRateTxt);
			System.out.println(nbrbRateNum+" ");
			double ownRate=nbrbRateNum*1.05;//TODO
			System.out.println(ownRate+" ");
			return Response.status(200).entity(ownRate+" ").build();
			 

		}
        private String calc(String nbrbRate) {
            return new Double(Double.parseDouble(nbrbRate) * 1.05).toString(); // TODO
        }
        @GET
		@Path("/test")
        @Produces(MediaType.APPLICATION_XML)
		public Currency test() {

			Currency cur=new Currency();
			cur.setId(100);
			cur.setName("test name");
			cur.setNumCode("SSS");
			cur.setScale(0);
			cur.setCharCode("111");
			return cur;
			 

		}
	}


