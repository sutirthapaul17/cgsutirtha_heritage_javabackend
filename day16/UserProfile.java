public class UserProfile {
    // Required fields
    private final String firstName;
    private final String lastName;
    private final String email;

    // Optional fields
    private final String phone;
    private final String address;
    private final String bio;
    private final String avatarUrl;
    private final boolean emailVerified;

    // Private constructor — only Builder can call this
    private UserProfile(Builder builder) {
        this.firstName     = builder.firstName;
        this.lastName      = builder.lastName;
        this.email         = builder.email;
        this.phone         = builder.phone;
        this.address       = builder.address;
        this.bio           = builder.bio;
        this.avatarUrl     = builder.avatarUrl;
        this.emailVerified = builder.emailVerified;
    }

    @Override public String toString() {
        return String.format(
                "UserProfile{name='%s %s', email='%s', phone='%s', bio='%s', verified=%b}"
                , firstName, lastName, email, phone, bio, emailVerified);
    }

    // ── Static inner Builder class ──
    public static class Builder {
        // Required
        private final String firstName;
        private final String lastName;
        private final String email;

        // Optional — defaults
        private String phone         = "";
        private String address       = "";
        private String bio           = "";
        private String avatarUrl     = "";
        private boolean emailVerified = false;

        // Required params in constructor
        public Builder(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName  = lastName;
            this.email     = email;
        }

        // Fluent setters — each returns 'this' for chaining
        public Builder phone(String phone) {
            this.phone = phone; return this;
        }
        public Builder address(String address) {
            this.address = address; return this;
        }
        public Builder bio(String bio) {
            this.bio = bio; return this;
        }
        public Builder avatarUrl(String url) {
            this.avatarUrl = url; return this;
        }
        public Builder emailVerified(boolean v) {
            this.emailVerified = v; return this;
        }

        // Terminal method — create the object
        public UserProfile build() {
            // Add validation if needed
            if (email == null || !email.contains("@"))
                throw new IllegalStateException("Invalid email");
            return new UserProfile(this);
        }
    }

    public static void main(String[] args) {
        // Minimal profile
        UserProfile minimal = new UserProfile.Builder("Alice", "Smith", "alice@email.com")
                .build();

        // Full profile — fluent chain
        UserProfile full = new UserProfile.Builder("Bob", "Jones", "bob@email.com")
                .phone("+1-555-0101")
                .address("123 Main St, NYC")
                .bio("Senior Java Developer with 10 years experience")
                .avatarUrl("https://cdn.example.com/bob.jpg")
                .emailVerified(true)
                .build();

        System.out.println(minimal);
        System.out.println(full);
    }
}
