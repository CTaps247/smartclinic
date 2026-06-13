@PostMapping("/{token}")
public ResponseEntity<Map<String, String>> addPrescription(
        @Valid @RequestBody Prescription prescription,
        @PathVariable String token) {

    Map<String, String> response = new HashMap<>();

    if (token == null || token.isEmpty()) {
        response.put("error", "Invalid token");
        return ResponseEntity.status(401).body(response);
    }

    response.put("message", "Prescription added successfully");
    return ResponseEntity.ok(response);
}