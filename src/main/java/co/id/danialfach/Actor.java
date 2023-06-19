package co.id.danialfach;

import java.util.List;

public record Actor(int id, String name, List<Movie> movies) {}
