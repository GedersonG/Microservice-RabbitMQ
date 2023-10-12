package api.eventapp.domain.model;

public class EventModel {

    private Long eventId;

    private String title;

    private String description;

    private int maxPeoplePerEvent;

    public EventModel() {
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", maxPeoplePerEvent=" + maxPeoplePerEvent +
                '}';
    }

    public EventModel(Long eventId, String title, String description, int maxPeoplePerEvent) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.maxPeoplePerEvent = maxPeoplePerEvent;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxPeoplePerEvent() {
        return maxPeoplePerEvent;
    }

    public void setMaxPeoplePerEvent(int maxPeoplePerEvent) {
        this.maxPeoplePerEvent = maxPeoplePerEvent;
    }
}
