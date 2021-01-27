package nextstep.subway.path.dto;

import nextstep.subway.station.domain.Station;
import nextstep.subway.station.dto.StationResponse;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PathResponse {
    private List<StationResponse> stations;
    private int distance;

    private PathResponse(List<StationResponse> stations, int distance) {
        this.stations = stations;
        this.distance = distance;
    }

    public static PathResponse of(List<Station> stations, int distance) {
        List<StationResponse> responses = stations.stream()
                .map(StationResponse::of)
                .collect(toList());
        return new PathResponse(responses, distance);
    }

    public List<StationResponse> getStations() {
        return stations;
    }
}
