package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.SubRouteDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

   // @Transactional    //----Eska use hmlog esliye krte h kyu ki ye ek hi transection krta h ek baar me
    public void addBus(BusDto busDto) {

        //create Route entity

        Route route = new Route();
        route.setFromLocation(busDto.getRoute().getFromLocation());
        route.setToLocation(busDto.getRoute().getToLocation());
        route.setFromDate(busDto.getRoute().getFromDate());
        route.setToDate(busDto.getRoute().getToDate());
        route.setTotalDuration(busDto.getRoute().getTotalDuration());
        route.setFromTime(busDto.getRoute().getFromTime());
        route.setToTime(busDto.getRoute().getToTime());

         Route savedRoute= routeRepository.save(route);

            //create Bus entity

            Bus bus = new Bus();
            bus.setBusNumber(busDto.getBusNumber());
            bus.setBusType(busDto.getBusType());
            bus.setPrice(busDto.getPrice());
            bus.setTotalSeats(busDto.getTotalSeats());
            bus.setAvailableSeats(busDto.getAvailableSeats());

        //Associate Bus with Route
        bus.setRoute(route);

        //save Bus and Route entities
         Bus savedBus= busRepository.save(bus);
         Route routeUpdate= routeRepository.findById(savedRoute.getId()).get();
         routeUpdate.setBus(savedBus);
         routeRepository.save(routeUpdate);

        //if there are sub-route,create and save them
        if (busDto.getSubRoutes() != null && !busDto.getSubRoutes().isEmpty()) {
            for (SubRouteDto subRouteDto : busDto.getSubRoutes()) {
                SubRoute subRoute= new SubRoute();
                subRoute.setFromLocation(subRouteDto.getFromLocation());
                subRoute.setToLocation(subRouteDto.getToLocation());
                subRoute.setFromDate(subRouteDto.getFromDate());
                subRoute.setToDate(subRouteDto.getToDate());
                subRoute.setTotalDuration(subRouteDto.getTotalDuration());
                subRoute.setFromTime(subRouteDto.getFromTime());
                subRoute.setToTime(subRouteDto.getToTime());

                subRoute.setRoute(route);

               subRouteRepository.save(subRoute);
            }
        }

    }
}

