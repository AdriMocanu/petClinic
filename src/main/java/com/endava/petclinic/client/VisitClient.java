package com.endava.petclinic.client;

import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Visit;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VisitClient extends BaseClient {

    public Response createVisit (Visit visit) {

        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(visit)

                .when()
                .post("api/visits");
    }

    public Response getVisitById(Long visitId) {

        return getBasicRestConfig()
                .pathParam("visitId", visitId)
                .when()
                .get("api/visits/{visitId}");
    }

    public Response getVisitList() {

        return getBasicRestConfig()

                .when()
                .get("api/visits");
    }

    public Response deleteVisitById(Long visitId) {

        return getBasicRestConfig()
                .pathParam("visitId", visitId)
                .when()
                .delete("api/visits/{visitId}");
    }

    public Response updateVisitById(Long visitId, Visit visit) {

        return getBasicRestConfig()
                .pathParam("visitId", visitId)
                .body(visit)
                .contentType(ContentType.JSON)
                .when()
                .put("api/visits/{visitId}");
    }
}
