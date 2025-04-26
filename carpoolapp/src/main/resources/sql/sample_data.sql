-- Insert a sample driver
INSERT INTO users (name, email, password, role) VALUES
('Alice Driver', 'alice@example.com', 'hashed_password', 'DRIVER');

-- Insert a sample rider
INSERT INTO users (name, email, password, role) VALUES
('Bob Rider', 'bob@example.com', 'hashed_password', 'RIDER');

-- Insert a driver trip
INSERT INTO driver_trip (user_id, source_lat, source_lng, dest_lat, dest_lng, time, seats_available) VALUES
(1, 12.9716, 77.5946, 13.0827, 80.2707, '2025-04-26 10:00:00', 3);

-- Insert a ride request
INSERT INTO ride_request (user_id, source_lat, source_lng, dest_lat, dest_lng, time) VALUES
(2, 12.9719, 77.5950, 13.0830, 80.2710, '2025-04-26 10:00:00');


-- Insert a test match between a driver and a rider
INSERT INTO matches (driver_trip_id, ride_request_id, created_at)
VALUES 
(1, 1, CURRENT_TIMESTAMP);

