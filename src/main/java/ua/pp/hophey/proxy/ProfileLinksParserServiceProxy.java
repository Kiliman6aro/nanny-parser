package ua.pp.hophey.proxy;

import ua.pp.hophey.repositories.LinksRepository;
import ua.pp.hophey.services.ProfileLinksParserService;
import ua.pp.hophey.services.ProfileLinksService;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class ProfileLinksParserServiceProxy implements ProfileLinksService {

    private final ProfileLinksParserService profileLinksParserService;

    private final LinksRepository repository;

    public ProfileLinksParserServiceProxy(ProfileLinksParserService profileLinksParserService, LinksRepository repository) {
        this.profileLinksParserService = profileLinksParserService;
        this.repository = repository;
    }

    public List<String> getProfilesLinks() {

        File file = new File("storage/links.json");

        if (file.exists()) {
            long lastModified = file.lastModified();

            Instant lastModifiedInstant = Instant.ofEpochMilli(lastModified);
            Instant now = Instant.now();

            Duration duration = Duration.between(lastModifiedInstant, now);

            if (duration.toHours() >= 24) {
                System.out.println("Update links with grub...");
                return profileLinksParserService.getProfilesLinks();
            } else {
                System.out.println("Load from cache.");
                return repository.loadAll();
            }
        } else {
            System.out.println("File does not exist. Update links with grub...");
            return profileLinksParserService.getProfilesLinks();
        }
    }
}
